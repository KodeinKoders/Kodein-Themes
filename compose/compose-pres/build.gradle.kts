@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose)
    `maven-publish`
}

kotlin {
    explicitApi()

    js(IR) {
        browser()
    }

    targets.all {
        compilations.all {
            kotlinOptions.allWarningsAsErrors = true
        }
    }

    sourceSets {
        named("jsMain") {
            dependencies {
                implementation(compose.web.core)
                implementation(compose.runtime)

                api(projects.base)
                api(projects.compose.composeWeb)
                api(libs.composeUrPres)
                api(libs.composeUrPres.emojis)
                api(libs.composeUrPres.sourceCode)
            }
        }

        all {
            languageSettings {
                optIn("org.jetbrains.compose.web.ExperimentalComposeWebApi")
                optIn("org.jetbrains.compose.web.ExperimentalComposeWebStyleApi")
                optIn("kotlin.time.ExperimentalTime")
            }
        }
    }
}
