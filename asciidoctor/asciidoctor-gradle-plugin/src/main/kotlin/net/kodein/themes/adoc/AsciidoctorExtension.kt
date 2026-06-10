package net.kodein.themes.adoc

import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.file.Directory
import org.gradle.api.tasks.Copy
import org.gradle.api.tasks.TaskProvider
import org.gradle.kotlin.dsl.invoke
import org.gradle.kotlin.dsl.register

abstract class AsciidoctorExtension(val project: Project) {

    val commonResources: TaskProvider<Copy> = project.tasks.register<Copy>(
        name = "copyCommonAsciidoctorResources",
    )

    inner class AsciidoctorDirectory(
        val name: String,
        val directory: Directory,
    ) {
        val adocResources = project.tasks.register("copy${name.capitalize()}Resources") {
            dependsOn(commonResources)
        }

        private val _backends = ArrayList<AsciidoctorBackend>()
        val backends: List<AsciidoctorBackend> get() = _backends

        fun pdf(
            configuration: AsciidoctorPdf.() -> Unit = {},
        ) = AsciidoctorPdf(register(name, directory, "pdf"))
            .apply(configuration)
            .apply { backendResources.configure { dependsOn(adocResources) } }
            .also { _backends.add(it) }

        fun html(
            configuration: AsciidoctorHtml.() -> Unit = {},
        ) = AsciidoctorHtml(register(name, directory, "html"))
            .apply(configuration)
            .apply { backendResources.configure { dependsOn(adocResources) } }
            .also { _backends.add(it) }
    }

    private val _directories = ArrayList<AsciidoctorDirectory>()
    val directories: List<AsciidoctorDirectory> get() = _directories

    fun directory(
        directory: Directory,
        name: String = directory.asFile.name,
        configuration: AsciidoctorDirectory.() -> Unit = {},
    ) = AsciidoctorDirectory(name, directory)
        .apply(configuration)
        .also { _directories.add(it) }

    private var groupTasks = HashMap<String, TaskProvider<Task>>()

    private fun addToGroup(group: String, task: TaskProvider<*>) {
        val groupTask = groupTasks.getOrPut(group) {
            project.tasks.register<Task>("asciidoctor${group.capitalize()}") {
                this.group = "asciidoctor"
            }
        }
        groupTask.configure { dependsOn(task) }
    }

    private fun register(
        name: String,
        directory: Directory,
        backendName: String,
    ): TaskProvider<AsciidoctorTask> {
        val task = project.tasks.register<AsciidoctorTask>(
            name = "asciidoctor${name.capitalize()}${backendName.capitalize()}",
        ) {
            group = "asciidoctor"
            backend.set(backendName)
            inputDir.set(directory)
            outputDir.set(project.layout.buildDirectory.dir("asciidoctor/${name}/${backendName}"))
        }

        addToGroup("all", task)
        addToGroup(backendName, task)

        return task
    }

    abstract inner class AsciidoctorBackend(
        val backend: TaskProvider<AsciidoctorTask>,
    ) {
        val backendResources: TaskProvider<Copy> = project.tasks.register<Copy>(
            name = "copy${backend.name.capitalize()}Resources",
        ).also { backend { dependsOn(it) } }
    }

    inner class AsciidoctorPdf(asciidoctor: TaskProvider<AsciidoctorTask>) : AsciidoctorBackend(asciidoctor) {
        private fun baseTheme(
            baseTheme: String,
            resourceProject: Project,
        ) {
            backend {
                dependsOn(resourceProject.tasks.named("importResourceFiles"))

                val resources = resourceProject.layout.buildDirectory.get().dir("resources")
                val rougeThemeFile = resources.file("rouge-themes/kodein-$baseTheme.rb")
                val iconsDir = resources.dir("icons")
                val pdfThemesDir = resources.dir("pdf-themes")
                val fontDir = resources.dir("font")

                inputs.dir(resources)
                inputs.files(rougeThemeFile)
                inputs.dir(iconsDir)
                inputs.dir(pdfThemesDir)
                inputs.dir(fontDir)

                requires.add(rougeThemeFile.asFile.absolutePath)

                attrs {
                    icons("images")
                    iconsDir(iconsDir.asFile.absolutePath)
                    attribute("icontype", "svg")
                    sourceHighlighter("rouge")
                    attribute("rouge-style", "kodein-$baseTheme")
                    attribute("pdf-themes-imagesdir", pdfThemesDir.dir("images").asFile.absolutePath)
                    attribute("pdf-fontsdir", fontDir.asFile.absolutePath)
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
                attrs {
                    attribute("pdf-themesdir", resourceProject.layout.buildDirectory.dir("resources/pdf-themes").get().asFile.absolutePath)
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
        task: TaskProvider<AsciidoctorTask>,
    ) : AsciidoctorBackend(task) {
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

            backendResources {
                dependsOn(extractCss)
                val resources = resourceProject.layout.buildDirectory.dir("resources")

                into(backend.map { it.outputDir.get() })

                into("css") {
                    from(extractCss)
                    from(resources.map { it.file("html-themes/kodein-$baseTheme.css") })
                    from(resources.map { it.file("html-themes/images/logo-$baseTheme.svg") })
                    from(resources.map { it.dir("html-themes") }) {
                        include { it.name.startsWith("kodein-base-") }
                    }
                    if (customThemeDir != null) {
                        from(customThemeDir)
                    }
                }
                into("font") {
                    from(resources.map { it.dir("font") }) {
                        include {
                            (it.name.startsWith("JetBrainsMono-") || it.name.startsWith("LCTPicon-"))
                                    && ("withCallouts" !in it.name)
                        }
                    }
                    from(resources.map { it.dir("webfont") })
                }
                into("icons") {
                    from(resources.map { it.dir("icons") })
                }
            }

            backend {
                dependsOn(backendResources)
                val resources = resourceProject.layout.buildDirectory.get().dir("resources")
                val rougeThemeFile = resources.file("rouge-themes/kodein-$baseTheme.rb")

                inputs.files(rougeThemeFile)

                requires.add(rougeThemeFile.asFile.absolutePath)

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
                attrs {
                    linkCss(true)
                    styleSheetName("{relRootOutputDir}/css/kodein-$theme.css")
                    attribute("copyCss", resourceProject.layout.buildDirectory.file("resources/html-themes/kodein-$theme.css").get().asFile.absolutePath)
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
