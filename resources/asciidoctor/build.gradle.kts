plugins {
    id("net.kodein.gradle.resources.resource-files")
    `maven-publish`
}

dependencies {
    resourceFiles(project(":base:base-resources"))
}
