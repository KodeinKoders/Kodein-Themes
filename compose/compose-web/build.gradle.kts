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
            }
        }
    }
}
