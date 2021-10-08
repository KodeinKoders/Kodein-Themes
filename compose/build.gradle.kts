plugins {
    id("org.jetbrains.compose") version "1.0.0-alpha4-build396" apply false
}

subprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
    }
}
