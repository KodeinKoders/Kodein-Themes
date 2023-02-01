plugins {
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.resourceFiles)
    `maven-publish`
}

dependencies {
    resourceFiles(projects.base.baseResources)
}
