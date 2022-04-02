plugins {
    kotlin("multiplatform") version "1.6.10" apply false
    id("net.kodein.gradle.resources.resource-files") version "1.0.0" apply false
}

allprojects {
    group = "net.kodein.themes"
    version = "1.5.0"

    repositories {
        mavenLocal()
        mavenCentral()
    }
}
