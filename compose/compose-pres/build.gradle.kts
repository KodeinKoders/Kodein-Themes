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
                api("net.kodein.pres:compose-ur-pres:1.0")
                api("net.kodein.pres:emojis:1.0")
                api("net.kodein.pres:source-code:1.0")
            }
        }
    }
}
