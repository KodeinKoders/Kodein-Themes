@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.kotlin.multiplatform) apply false
}

allprojects {
    group = "net.kodein.themes"
    version = "1.9.0"
}
