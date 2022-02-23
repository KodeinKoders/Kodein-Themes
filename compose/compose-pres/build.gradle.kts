plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
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
        val jsMain by getting {
            dependencies {
                implementation(compose.web.core)
                implementation(compose.runtime)

                api(project(":base"))
                api(project(":compose:compose-web"))
                val cupVer = "1.3.0"
                api("net.kodein.pres:compose-ur-pres:$cupVer")
                api("net.kodein.pres:emojis:$cupVer")
                api("net.kodein.pres:source-code:$cupVer")
            }
        }

        all {
            languageSettings {
                optIn("kotlin.RequiresOptIn")
                optIn("org.jetbrains.compose.web.ExperimentalComposeWebApi")
                optIn("org.jetbrains.compose.web.ExperimentalComposeWebStyleApi")
                optIn("kotlin.time.ExperimentalTime")
            }
        }
    }
}
