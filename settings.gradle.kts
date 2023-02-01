rootProject.name = "Kodein-Themes"

pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
    }
}


include(
    ":base",
    ":base:base-resources",
    ":resources:illustrations",
    ":resources:asciidoctor",
    ":compose:compose-web",
    ":compose:compose-pres",
    ":compose:compose-pres:compose-pres-resources"
)

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
