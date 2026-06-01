import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    id("publish-convention")
}

kotlin {
    explicitApi()

    jvm()
    jvmToolchain(21)

    js {
        browser()
        useCommonJs()
    }

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
    }
}
