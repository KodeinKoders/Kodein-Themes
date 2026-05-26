@file:Suppress("LeakingThis")

import org.asciidoctor.Asciidoctor
import org.asciidoctor.Attributes
import org.asciidoctor.Options
import org.asciidoctor.SafeMode
import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.logging.Logger
import org.gradle.api.logging.Logging
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.MapProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import org.gradle.kotlin.dsl.submit
import org.gradle.work.Incremental
import org.gradle.work.InputChanges
import org.gradle.workers.WorkAction
import org.gradle.workers.WorkParameters
import org.gradle.workers.WorkerExecutor
import javax.inject.Inject
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

abstract class AsciidoctorTask : DefaultTask() {

    @get:InputDirectory @get:Incremental
    abstract val inputDir: DirectoryProperty

    @get:OutputDirectory
    abstract val outputDir: DirectoryProperty

    @get:Input @get:Optional
    abstract val backend: Property<String>

    @get:Input @get:Optional
    abstract val attrs: MapProperty<String, Any>

    init {
        group = "build"
        backend.convention("html")
        outputDir.convention(project.layout.buildDirectory.dir(backend.map { "asciidoctor/$it" }))
        attrs.convention(emptyMap())
    }

    internal interface AdocWorkParameters : WorkParameters {
        val name: Property<String>
        val inputFile: RegularFileProperty
        val outputFile: RegularFileProperty
        val backend: Property<String>
        val attrs: MapProperty<String, Any>
    }

    companion object {
        val adoc = Asciidoctor.Factory.create()
    }

    internal abstract class AdocWorkAction : WorkAction<AdocWorkParameters> {

        val logger: Logger = Logging.getLogger("AdocWorkAction")

        override fun execute() {
            logger.info("Adoc(${parameters.backend.get()}): ${parameters.name.get()}")
            val output = parameters.outputFile.get().asFile
            output.parentFile.mkdirs()
            adoc.convertFile(
                parameters.inputFile.get().asFile,
                Options.builder()
                    .safe(SafeMode.UNSAFE)
                    .backend(parameters.backend.get())
                    .toFile(output)
                    .attributes(
                        Attributes.builder()
                            .apply {
                                parameters.attrs.get().forEach { (k, v) -> attribute(k, v) }
                            }
                            .build()
                    )
                    .build()
            )
        }
    }

    @get:Inject
    abstract val workerExecutor: WorkerExecutor

    @OptIn(ExperimentalUuidApi::class)
    @TaskAction
    fun execute(inputChanges: InputChanges) {
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
                }
            }
        workQueue.await()
    }
}