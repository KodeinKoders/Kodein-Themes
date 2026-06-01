@file:Suppress("LeakingThis")

package net.kodein.themes.adoc

import org.asciidoctor.Attributes
import org.asciidoctor.AttributesBuilder
import org.asciidoctor.Options
import org.asciidoctor.SafeMode
import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.logging.Logger
import org.gradle.api.logging.Logging
import org.gradle.api.provider.MapProperty
import org.gradle.api.provider.Property
import org.gradle.api.provider.SetProperty
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity
import org.gradle.api.tasks.TaskAction
import org.gradle.kotlin.dsl.submit
import org.gradle.work.Incremental
import org.gradle.work.InputChanges
import org.gradle.workers.WorkAction
import org.gradle.workers.WorkParameters
import org.gradle.workers.WorkerExecutor
import javax.inject.Inject


@CacheableTask
abstract class AsciidoctorTask : DefaultTask() {

    @get:InputDirectory @get:Incremental @get:PathSensitive(PathSensitivity.RELATIVE)
    abstract val inputDir: DirectoryProperty

    @get:OutputDirectory
    abstract val outputDir: DirectoryProperty

    @get:Input
    abstract val backend: Property<String>

    @get:Input @get:Optional
    abstract val attrs: MapProperty<String, Any>

    @get:Input @get:Optional
    abstract val attrVariables: MapProperty<String, String>

    @get:Input @get:Optional
    abstract val requires: SetProperty<String>

    init {
        outputDir.convention(project.layout.buildDirectory.dir(backend.map { "asciidoctor/$it" }))
        attrs.convention(emptyMap())
        attrVariables.convention(emptyMap())
        requires.convention(emptySet())
    }

    fun attrs(block: AttributesBuilder.() -> Unit) {
        @Suppress("DEPRECATION")
        val map = Attributes.builder().apply(block).build().map()
        attrs.putAll(map)
    }

    internal interface AdocWorkParameters : WorkParameters {
        val name: Property<String>
        val inputFile: RegularFileProperty
        val outputFile: RegularFileProperty
        val backend: Property<String>
        val attrs: MapProperty<String, Any>
        val attrVariables: MapProperty<String, String>
    }

    internal abstract class AdocWorkAction : WorkAction<AdocWorkParameters> {

        val logger: Logger = Logging.getLogger("AdocWorkAction")

        override fun execute() {
            logger.info("Adoc(${parameters.backend.get()}): ${parameters.name.get()}")
            val output = parameters.outputFile.get().asFile
            output.parentFile.mkdirs()
            AsciidoctorPlugin.adoc.convertFile(
                parameters.inputFile.get().asFile,
                Options.builder()
                    .safe(SafeMode.UNSAFE)
                    .backend(parameters.backend.get())
                    .mkDirs(true)
                    .toFile(output)
                    .attributes(
                        Attributes.builder()
                            .apply {
                                parameters.attrs.get().forEach { (key, value) ->
                                    attribute(
                                        key,
                                        value.let {
                                            if (it is String) {
                                                var str = it as String
                                                parameters.attrVariables.get().forEach { (k, v) -> str = str.replace("{$k}", v) }
                                                str
                                            } else it
                                        }
                                    )
                                }
                            }
                            .build()
                    )
                    .build()
            )
        }
    }

    @get:Inject
    abstract val workerExecutor: WorkerExecutor

    @TaskAction
    internal fun execute(inputChanges: InputChanges) {
        if (requires.get().isNotEmpty()) {
            AsciidoctorPlugin.adoc.requireLibraries(requires.get())
        }
        val workQueue = workerExecutor.noIsolation()
        inputChanges.getFileChanges(inputDir)
            .filter { it.file.isFile && it.file.extension  == "adoc" }
            .forEach {
                val relativeInputFile = it.file.relativeTo(inputDir.get().asFile)
                workQueue.submit(AdocWorkAction::class) {
                    name.set(relativeInputFile.path)
                    inputFile.set(it.file)
                    if (relativeInputFile.parentFile != null) {
                        outputFile.set(outputDir.get().asFile.resolve(relativeInputFile.parentFile.resolve(it.file.nameWithoutExtension + "." + this@AsciidoctorTask.backend.get())))
                    } else {
                        outputFile.set(outputDir.get().asFile.resolve(it.file.nameWithoutExtension + "." + this@AsciidoctorTask.backend.get()))
                    }
                    backend.set(this@AsciidoctorTask.backend.get())
                    attrs.set(this@AsciidoctorTask.attrs.get())
                    attrVariables.putAll(
                        mapOf(
                            "relRootOutputDir" to ((outputDir.get().asFile.relativeTo(outputFile.get().asFile.parentFile).path).takeIf { it.isNotBlank() } ?: ".")
                        )
                    )
                    attrVariables.putAll(this@AsciidoctorTask.attrVariables.get())
                }
            }
        workQueue.await()
    }
}
