plugins {
    alias(libs.plugins.resourceFiles)
}

dependencies {
    resourceFiles(projects.asciidoctorResources)
}

tasks.register<AsciidoctorTask>("asciidoctorPdf") {
    description = "Generate PDFs from Adoc files"
    dependsOn(tasks.importResourceFiles)
    requires.add(layout.buildDirectory.file("resources/rouge-themes/kodein_light.rb").get().asFile.absolutePath)
    backend = "pdf"
    inputDir = layout.projectDirectory.dir("adocs")
    inputs.dir("themes")
    inputs.dir("build/resources")
    attrs = mapOf(
        "icons" to "font",
        "iconsdir" to layout.buildDirectory.dir("resources/icons").get().asFile.absolutePath,
//        "icontype" to "svg",
        "source-highlighter" to "rouge",
        "rouge-style" to "kodein_light",
        "pdf-themes-imagesdir" to layout.buildDirectory.dir("resources/pdf-themes/images").get().asFile.absolutePath,
        "pdf-themesdir" to layout.projectDirectory.dir("themes").asFile.absolutePath,
        "pdf-fontsdir" to layout.buildDirectory.dir("resources/font").get().asFile.absolutePath,
        "pdf-theme" to "a4",
    )
}
