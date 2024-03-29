@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.kotlin.multiplatform) apply false
}

allprojects {
    group = "net.kodein.themes"
    version = "2.0.0"
}
