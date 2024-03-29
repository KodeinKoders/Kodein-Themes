plugins {
    alias(libs.plugins.resourceFiles)
    `maven-publish`
}

dependencies {
    resourceFiles(projects.base.resources.baseResourcesFont)
}
