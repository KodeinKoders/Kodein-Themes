package net.kodein.themes.adoc

import org.asciidoctor.Attributes
import org.asciidoctor.Options
import org.asciidoctor.SafeMode
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction


@CacheableTask
abstract class AsciidoctorExtractCssTask : DefaultTask() {

    @get:OutputDirectory
    val outputDir = project.layout.buildDirectory.dir("tmp/asciidoctor/html")

    @TaskAction
    internal fun execute() {
        outputDir.get().asFile.mkdirs()
        val outputHtml = outputDir.get().asFile.resolve("output.html")
        AsciidoctorPlugin.adoc.convert(
            "\n",
            Options.builder()
                .safe(SafeMode.UNSAFE)
                .toFile(outputHtml)
                .attributes(
                    Attributes.builder()
                        .linkCss(true)
                        .copyCss(true)
                        .build()
                )
                .build()
        )
        outputHtml.delete()
    }
}
