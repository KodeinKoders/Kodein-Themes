import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.kotlin.plugin.compose)
    `maven-publish`
}

kotlin {
    explicitApi()

    jvm()

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
    }

    sourceSets {
        commonMain.dependencies {
            api(compose.runtime)
            api(compose.foundation)
            api(compose.material)
            api(compose.materialIconsExtended)
            api(compose.components.resources)

            api(projects.compose.composeM2)
            api(libs.bundles.cup)
            api(libs.emoji.compose)
        }
    }
}
