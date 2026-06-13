package net.kodein.themes.adoc

import org.gradle.api.Named
import org.gradle.api.PolymorphicDomainObjectContainer
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.file.Directory
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.tasks.Copy
import org.gradle.api.tasks.TaskProvider
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.invoke
import org.gradle.kotlin.dsl.register

abstract class AsciidoctorExtension(val project: Project) {

    inner class AsciidoctorDirectory(
        private val name: String,
    ): Named {
        override fun getName(): String = name

        val directory = project.objects.directoryProperty()

        val backends: PolymorphicDomainObjectContainer<AsciidoctorBackend> =
            project.objects.polymorphicDomainObjectContainer(AsciidoctorBackend::class.java).apply {
                registerFactory(AsciidoctorPdf::class.java) {
                    val (copyResources, backend) = registerBackend(
                        name = it,
                        directory = directory,
                        directoryName = name,
                        backendName = "pdf",
                    )
                    AsciidoctorPdf(
                        name = it,
                        copyResources = copyResources,
                        backend = backend,
                    )
                }
                registerFactory(AsciidoctorHtml::class.java) {
                    val (copyResources, backend) = registerBackend(
                        name = it,
                        directory = directory,
                        directoryName = name,
                        backendName = "html",
                    )
                    AsciidoctorHtml(
                        name = it,
                        copyResources = copyResources,
                        backend = backend,
                    )
                }
            }

        fun pdf(
            name: String = "pdf",
            configuration: AsciidoctorPdf.() -> Unit = {},
        ) = backends.create<AsciidoctorPdf>(name) {
            configuration()
        }

        fun html(
            name: String = "html",
            configuration: AsciidoctorHtml.() -> Unit = {},
        ) = backends.create<AsciidoctorHtml>(name) {
            configuration()
        }
    }

    val directories = project.objects.domainObjectContainer(AsciidoctorDirectory::class.java) {
        AsciidoctorDirectory(
            name = it,
        )
    }

    fun directory(
        directory: Directory,
        name: String = directory.asFile.name,
        configuration: AsciidoctorDirectory.() -> Unit = {},
    ) = directories.create(name) {
        this.directory.set(directory)
        configuration()
    }

    private var groupTasks = HashMap<String, TaskProvider<Task>>()

    private fun addToGroup(group: String, task: TaskProvider<*>) {
        val groupTask = groupTasks.getOrPut(group) {
            project.tasks.register<Task>("asciidoctor${group.capitalize()}") {
                this.group = "asciidoctor"
            }
        }
        groupTask.configure { dependsOn(task) }
    }

    private fun registerBackend(
        name: String,
        directoryName: String,
        directory: DirectoryProperty,
        backendName: String,
    ): Pair<TaskProvider<Copy>, TaskProvider<AsciidoctorTask>> {
        val copyResources: TaskProvider<Copy> = project.tasks.register<Copy>(
            name = "copyAsciidoctor${directoryName.capitalize()}${name.capitalize()}Resources",
        ) {
            into(project.layout.buildDirectory.dir("tmp/asciidoctor/pdf/$directoryName-${name}"))
        }

        val backend = project.tasks.register<AsciidoctorTask>(
            name = "asciidoctor${directoryName.capitalize()}${name.capitalize()}",
        ) {
            dependsOn(copyResources)
            group = "asciidoctor"
            backend.set(backendName)
            inputDir.set(directory)
            outputDir.set(project.layout.buildDirectory.dir("asciidoctor/${directoryName}/${name}"))
        }

        addToGroup("all", backend)
        addToGroup(backendName, backend)

        return Pair(copyResources, backend)
    }

    abstract inner class AsciidoctorBackend(
        private val name: String,
        val copyResources: TaskProvider<Copy>,
        val backend: TaskProvider<AsciidoctorTask>,
    ) : Named {
        val resourcesDir get() = project.layout.dir(project.provider { copyResources.get().destinationDir })
        override fun getName(): String = name
    }

    inner class AsciidoctorPdf(
        name: String,
        copyResources: TaskProvider<Copy>,
        backend: TaskProvider<AsciidoctorTask>,
    ) : AsciidoctorBackend(name, copyResources, backend) {

        private fun baseTheme(
            baseTheme: String,
            resourceProject: Project,
        ) {
            val originalResources = resourceProject.layout.buildDirectory.dir("resources")

            copyResources {
                dependsOn(resourceProject.tasks.named("importResourceFiles"))
                into("icons") {
                    from(originalResources.map { it.dir("icons") })
                }
                into("theme-images") {
                    from(originalResources.map { it.dir("pdf-themes/images") })
                }
                into("font") {
                    from(originalResources.map { it.dir("font") })
                }
            }

            backend {
                dependsOn(resourceProject.tasks.named("importResourceFiles"))

                inputs.dir(resourcesDir)

                val rougeThemeRbFile = originalResources.map { it.file("rouge-themes/kodein-$baseTheme.rb") }
                inputs.file(rougeThemeRbFile)
                requires.add(rougeThemeRbFile.map { it.asFile.absolutePath })

                attrs {
                    icons("images")
                    iconsDir(resourcesDir.get().dir("icons").asFile.absolutePath)
                    attribute("icontype", "svg")
                    sourceHighlighter("rouge")
                    attribute("rouge-style", "kodein-$baseTheme")
                    attribute("pdf-themes-imagesdir", resourcesDir.get().dir("theme-images").asFile.absolutePath)
                    attribute("pdf-fontsdir", resourcesDir.get().dir("font").asFile.absolutePath)
                }
            }
        }

        fun kodeinTheme(
            theme: String,
            resourceProject: Project = project,
        ) {
            baseTheme(
                baseTheme = theme,
                resourceProject = resourceProject,
            )
            backend {
                val pdfThemesDir = resourceProject.layout.buildDirectory.dir("resources/pdf-themes")
                inputs.dir(pdfThemesDir)
                attrs {
                    attribute("pdf-themesdir", pdfThemesDir.get().asFile.absolutePath)
                    attribute("pdf-theme", "kodein-$theme")
                }
            }
        }

        fun customTheme(
            baseTheme: String,
            themesDir: Directory,
            themeName: String,
            resourceProject: Project = project,
        ) {
            baseTheme(
                baseTheme = baseTheme,
                resourceProject = resourceProject,
            )
            backend {
                inputs.dir(themesDir)
                attrs {
                    attribute("pdf-themesdir", themesDir.asFile.absolutePath)
                    attribute("pdf-theme", themeName)
                }
            }
        }
    }

    internal lateinit var extractCss: TaskProvider<AsciidoctorExtractCssTask>

    inner class AsciidoctorHtml(
        name: String,
        copyResources: TaskProvider<Copy>,
        backend: TaskProvider<AsciidoctorTask>,
    ) : AsciidoctorBackend(name, copyResources, backend) {

        private fun baseTheme(
            baseTheme: String,
            customThemeDir: Directory?,
            resourceProject: Project,
        ) {
            if (!::extractCss.isInitialized) {
                extractCss = project.tasks.register<AsciidoctorExtractCssTask>("extractCss") {
                    dependsOn(resourceProject.tasks.named("importResourceFiles"))
                }
            }

            val originalResources = resourceProject.layout.buildDirectory.dir("resources")

            copyResources {
                dependsOn(extractCss)
                dependsOn(resourceProject.tasks.named("importResourceFiles"))

                into(backend.map { it.outputDir.get() })

                into("css") {
                    from(extractCss)
                    from(originalResources.map { it.file("html-themes/kodein-$baseTheme.css") })
                    from(originalResources.map { it.file("html-themes/images/logo-$baseTheme.svg") })
                    from(originalResources.map { it.dir("html-themes") }) {
                        include { it.name.startsWith("kodein-base-") }
                    }
                    if (customThemeDir != null) {
                        from(customThemeDir)
                    }
                }
                into("font") {
                    from(originalResources.map { it.dir("font") }) {
                        include {
                            (it.name.startsWith("JetBrainsMono-") || it.name.startsWith("LCTPicon-"))
                                    && ("withCallouts" !in it.name)
                        }
                    }
                    from(originalResources.map { it.dir("webfont") })
                }
                into("icons") {
                    from(originalResources.map { it.dir("icons") })
                }
            }

            backend {
                dependsOn(resourceProject.tasks.named("importResourceFiles"))

                val rougeThemeRbFile = originalResources.map { it.file("rouge-themes/kodein-$baseTheme.rb") }
                inputs.file(rougeThemeRbFile)
                requires.add(rougeThemeRbFile.map { it.asFile.absolutePath })

                attrs {
                    icons("images")
                    iconsDir("{relRootOutputDir}/icons")
                    attribute("icontype", "svg")
                    sourceHighlighter("rouge")
                    attribute("rouge-css", "style")
                    attribute("rouge-style", "kodein-$baseTheme")
                }
            }
        }

        fun kodeinTheme(
            theme: String,
            resourceProject: Project = project,
        ) {
            baseTheme(
                baseTheme = theme,
                customThemeDir = null,
                resourceProject = resourceProject,
            )
            backend {
                val themeCssFile = resourceProject.layout.buildDirectory.file("resources/html-themes/kodein-$theme.css")
                inputs.file(themeCssFile)
                attrs {
                    linkCss(true)
                    styleSheetName("{relRootOutputDir}/css/kodein-$theme.css")
                    attribute("copyCss", themeCssFile.get().asFile.absolutePath)
                }
            }
        }

        fun customTheme(
            baseTheme: String,
            themesDir: Directory,
            themeName: String,
            resourceProject : Project = project,
        ) {
            baseTheme(
                baseTheme = baseTheme,
                customThemeDir = themesDir,
                resourceProject = resourceProject
            )
            backend {
                inputs.dir(themesDir)
                attrs {
                    linkCss(true)
                    attribute("foo", "barRr")
                    styleSheetName("{relRootOutputDir}/css/$themeName.css")
                }
            }
        }
    }
}
