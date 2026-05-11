import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.kotlin.plugin.compose)
    `maven-publish`
}

kotlin {
    explicitApi()

    jvm()
    jvmToolchain(21)

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
    }

    js {
        browser()
        useCommonJs()
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.bundles.compose)

            api(projects.base)
        }
    }
}
