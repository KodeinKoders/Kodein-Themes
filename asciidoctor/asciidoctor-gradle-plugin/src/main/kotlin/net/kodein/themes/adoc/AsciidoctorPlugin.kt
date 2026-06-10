package net.kodein.themes.adoc

import org.asciidoctor.Asciidoctor
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.dependencies


class AsciidoctorPlugin : Plugin<Project> {

    companion object {
        internal val adoc = Asciidoctor.Factory.create()
    }

    override fun apply(target: Project) {
        target.apply {
            plugin("net.kodein.gradle.resources.resource-files")
        }
        target.dependencies {
            "resourceFiles"("net.kodein.themes:asciidoctor-resources:${BuildConfig.VERSION}")
        }
        target.extensions.create<AsciidoctorExtension>("asciidoctor", target)
    }

}
