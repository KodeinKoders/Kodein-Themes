plugins {
    kotlin("multiplatform") version "1.5.31" apply false
    id("net.kodein.gradle.resources.resource-files") version "1.0.0" apply false
}

allprojects {
    group = "net.kodein.themes"
    version = "1.2.1"

    repositories {
        mavenLocal()
        mavenCentral()
    }
}
