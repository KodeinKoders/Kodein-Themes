rootProject.name = "Kodein-Themes"

pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

}

include(
    ":base",
    ":base:base-resources",
    ":resources:illustrations",
    ":compose:compose-web",
    ":compose:compose-pres",
    ":compose:compose-pres:compose-pres-resources"
)
