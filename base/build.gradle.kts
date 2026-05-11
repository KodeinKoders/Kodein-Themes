import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    `maven-publish`
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
