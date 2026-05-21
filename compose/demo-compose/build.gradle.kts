plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.kotlin.plugin.compose)
}

kotlin {
    jvm()
    jvmToolchain(21)

    sourceSets {
        commonMain.dependencies {
            implementation(libs.bundles.compose)
            implementation(compose.desktop.currentOs) {
                exclude("org.jetbrains.compose.material")
            }

            api(projects.compose)
        }
    }
}

compose.desktop.application {
    mainClass = "MainKt"
}
