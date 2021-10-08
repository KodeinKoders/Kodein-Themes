plugins {
    kotlin("multiplatform")
    `maven-publish`
}

kotlin {
    explicitApi()

    jvm()

    js(BOTH) {
        browser()
    }

    targets.all {
        compilations.all {
            kotlinOptions.allWarningsAsErrors = true
        }
    }
}
