plugins {
    id("org.jetbrains.compose") version "1.2.0-alpha01-dev686" apply false
}

subprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
    }
}
