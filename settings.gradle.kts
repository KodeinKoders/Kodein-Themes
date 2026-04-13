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
    ":asciidoctor-resources",
    ":compose",
    ":cup"
)

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
