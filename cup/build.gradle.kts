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

    sourceSets {
        commonMain.dependencies {
            api("org.jetbrains.compose.runtime:runtime:1.10.1")
            api("org.jetbrains.compose.foundation:foundation:1.10.1")
            api("org.jetbrains.compose.material:material:1.10.1")
            api("org.jetbrains.compose.material:material-icons-extended:1.7.3")
            api("org.jetbrains.compose.components:components-resources:1.10.1")

            api(projects.compose.composeM2)
            api(libs.bundles.cup)
            api(libs.emoji.compose)
        }
    }
}
