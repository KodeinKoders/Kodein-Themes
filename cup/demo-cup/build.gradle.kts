import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.kotlin.plugin.compose)
}

kotlin {
    jvm()
    jvmToolchain(21)

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
    }

    js {
        browser()
        useCommonJs()
        binaries.executable()
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.bundles.compose)
            implementation(libs.bundles.cup)
            implementation(libs.emoji.compose)

            api(projects.compose)
            api(projects.cup)
        }
        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
        }
    }
}

compose.desktop.application {
    mainClass = "MainKt"
}
