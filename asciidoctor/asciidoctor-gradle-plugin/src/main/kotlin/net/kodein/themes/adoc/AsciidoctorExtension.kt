package net.kodein.themes.adoc

import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.file.Directory
import org.gradle.api.tasks.TaskProvider
import org.gradle.kotlin.dsl.invoke
import org.gradle.kotlin.dsl.register

abstract class AsciidoctorExtension(val project: Project) {

    private var groupTasks = HashMap<String, TaskProvider<Task>>()

    private fun addToGroup(group: String, task: TaskProvider<*>) {
        val groupTask = groupTasks.getOrPut(group) {
            project.tasks.register<Task>("asciidoctor${group.replaceFirstChar { it.titlecase() }}") {
                this.group = "asciidoctor"
            }
        }
        groupTask.configure { dependsOn(task) }
    }

    private fun register(
        name: String,
        backendName: String,
    ): TaskProvider<AsciidoctorTask> {
        val task = project.tasks.register<AsciidoctorTask>(
            name = "asciidoctor${name.replaceFirstChar { it.titlecase() }}${backendName.replaceFirstChar { it.titlecase() }}",
        ) {
            group = "asciidoctor"
            backend.set(backendName)
        }

        addToGroup("all", task)
        addToGroup(backendName, task)

        return task
    }
    abstract class AsciidoctorTaskBuilder(val task: TaskProvider<AsciidoctorTask>)

    class AsciidoctorPdfTaskBuilder(task: TaskProvider<AsciidoctorTask>) : AsciidoctorTaskBuilder(task) {
        private fun baseTheme(
            baseTheme: String,
        ) {
            task {
                dependsOn(project.tasks.named("importResourceFiles"))

                val resources = project.layout.buildDirectory.get().dir("resources")
                val rougeThemeFile = resources.file("rouge-themes/kodein-$baseTheme.rb")
                val iconsDir = resources.dir("icons")
                val pdfThemesDir = resources.dir("pdf-themes")
                val fontDir = resources.dir("font")

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
        ) {
            baseTheme(theme)
            task {
                attrs {
                    attribute("pdf-themesdir", project.layout.buildDirectory.dir("resources/pdf-themes").get().asFile.absolutePath)
                    attribute("pdf-theme", "kodein-$theme")
                }
            }
        }

        fun customTheme(
            baseTheme: String,
            themesDir: Directory,
            themeName: String
        ) {
            baseTheme(baseTheme)
            task {
                inputs.dir(themesDir)
                attrs {
                    attribute("pdf-themesdir", themesDir.asFile.absolutePath)
                    attribute("pdf-theme", themeName)
                }
            }
        }
    }

    internal lateinit var extractCss: TaskProvider<AsciidoctorExtractCssTask>

    inner class AsciidoctorHtmlTaskBuilder(task: TaskProvider<AsciidoctorTask>) : AsciidoctorTaskBuilder(task) {
        private fun baseTheme(
            baseTheme: String,
            customThemeDir: Directory?,
        ) {
            project.tasks.named("importResourceFiles")
            if (!::extractCss.isInitialized) {
                extractCss = project.tasks.register<AsciidoctorExtractCssTask>("extractCss") {
                    dependsOn(project.tasks.named("importResourceFiles"))
                }
            }
            val copyResources = project.tasks.register("copy${task.name.replaceFirstChar { it.titlecase() }}Resources") {
                dependsOn(extractCss)
                val resources = project.layout.buildDirectory.dir("resources").get()
                val cssDir = task.get().outputDir.dir("css").get()
                val fontDir = task.get().outputDir.dir("font").get()
                val iconsDir = task.get().outputDir.dir("icons").get()

                inputs.dir(resources)
                if (customThemeDir != null) { inputs.dir(customThemeDir) }
                outputs.dirs(cssDir, fontDir, iconsDir)

                doLast {
                    project.copy {
                        from(extractCss)
                        into(cssDir)
                    }
                    project.copy {
                        from(resources.file("html-themes/kodein-$baseTheme.css"))
                        into(cssDir)
                    }
                    project.copy {
                        from(resources.file("html-themes/images/logo-$baseTheme.svg"))
                        into(cssDir)
                    }
                    project.copy {
                        from(resources.dir("html-themes"))
                        include { it.name.startsWith("kodein-base-") }
                        into(cssDir)
                    }
                    if (customThemeDir != null) {
                        project.copy {
                            from(customThemeDir)
                            into(cssDir)
                        }
                    }
                    project.copy {
                        from(resources.dir("font"))
                        into(fontDir)
                        include {
                            (it.name.startsWith("JetBrainsMono-") || it.name.startsWith("LCTPicon-"))
                                    && ("withCallouts" !in it.name)
                        }
                    }
                    project.copy {
                        from(resources.dir("webfont"))
                        into(fontDir)
                    }
                    project.copy {
                        from(resources.dir("icons"))
                        into(iconsDir)
                    }
                }
            }
            task {
                dependsOn(copyResources)
                val resources = project.layout.buildDirectory.get().dir("resources")
                val rougeThemeFile = resources.file("rouge-themes/kodein-$baseTheme.rb")

                inputs.files(rougeThemeFile)

                requires.add(rougeThemeFile.asFile.absolutePath)

                attrs {
                    icons("images")
                    iconsDir("./icons")
                    attribute("icontype", "svg")
                    sourceHighlighter("rouge")
                    attribute("rouge-style", "kodein-$baseTheme")
                }
            }
        }

        fun kodeinTheme(
            theme: String,
        ) {
            baseTheme(theme, null)
            task {
                attrs {
                    linkCss(true)
                    styleSheetName("css/kodein-$theme.css")
                    attribute("copyCss", project.layout.buildDirectory.file("resources/html-themes/kodein-$theme.css").get().asFile.absolutePath)
                }
            }
        }

        fun customTheme(
            baseTheme: String,
            themesDir: Directory,
            themeName: String
        ) {
            baseTheme(baseTheme, themesDir)
            task {
                inputs.dir(themesDir)
                attrs {
                    linkCss(true)
                    styleSheetName("css/$themeName.css")
                    attribute("copyCss", themesDir.file("$themeName.css").asFile.absolutePath)
                }
            }
        }
    }

    fun pdf(
        name: String,
        configuration: AsciidoctorPdfTaskBuilder.() -> Unit,
    ) = AsciidoctorPdfTaskBuilder(register(name, "pdf")).configuration()

    fun html(
        name: String,
        configuration: AsciidoctorHtmlTaskBuilder.() -> Unit,
    ) = AsciidoctorHtmlTaskBuilder(register(name, "html")).configuration()

}
