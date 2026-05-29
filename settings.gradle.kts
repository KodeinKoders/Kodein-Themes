rootProject.name = "Kodein-Themes"

pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
    }
}

include(
    ":base",
    ":base:resources:base-resources-font",
    ":base:resources:base-resources-svg",
    ":asciidoctor:asciidoctor-resources",
    ":asciidoctor:asciidoctor-gradle-plugin",
    ":compose",
    ":compose:demo-compose",
    ":cup",
    ":cup:demo-cup",
)

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
