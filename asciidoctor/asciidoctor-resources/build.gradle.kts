plugins {
    alias(libs.plugins.resourceFiles)
    id("publish-convention")
}

dependencies {
    resourceFiles(projects.base.resources.baseResourcesFont)
    resourceFiles(projects.base.resources.baseResourcesSvg)
}
