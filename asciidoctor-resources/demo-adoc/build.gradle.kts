plugins {
    alias(libs.plugins.resourceFiles)
}

dependencies {
    resourceFiles(projects.asciidoctorResources)
}

AsciidoctorTask.adoc.requireLibrary(layout.buildDirectory.file("resources/rouge-themes/kodein_light.rb").get().asFile.absolutePath)

val asciidoctorPdf = tasks.register("asciidoctorPdf") {
    description = "Generate all PDFs"
}

listOf("print", "light").forEach { theme ->
    val task = tasks.register<AsciidoctorTask>("asciidoctor${theme.replaceFirstChar { it.titlecase() }}Pdf") {
        description = "Generate $theme PDFs"
        dependsOn(tasks.importResourceFiles)
        backend = "pdf"
        inputDir = layout.projectDirectory.dir("adocs")
        outputDir = project.layout.buildDirectory.dir(backend.map { "asciidoctor/pdf/$theme" })
        inputs.dir("themes")
        inputs.dir("build/resources")
        attrs = mapOf(
            "icons" to "images",
            "iconsdir" to layout.buildDirectory.dir("resources/icons").get().asFile.absolutePath,
            "icontype" to "svg",
            "source-highlighter" to "rouge",
            "rouge-style" to "kodein_light",
            "pdf-themes-imagesdir" to layout.buildDirectory.dir("resources/pdf-themes/images").get().asFile.absolutePath,
            "pdf-themesdir" to layout.projectDirectory.dir("themes").asFile.absolutePath,
            "pdf-fontsdir" to layout.buildDirectory.dir("resources/font").get().asFile.absolutePath,
            "pdf-theme" to theme,
        )
    }
    asciidoctorPdf.configure { dependsOn(task) }
}
