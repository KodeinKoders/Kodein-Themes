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
    ":base:resources:base-resources-font",
    ":base:resources:base-resources-svg",
    ":asciidoctor-resources",
    ":compose",
    ":compose:compose-m2",
    ":cup",
    ":cup:cup-resources",
)

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
