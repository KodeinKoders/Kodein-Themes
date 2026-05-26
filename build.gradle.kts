plugins {
    alias(libs.plugins.kotlin.multiplatform) apply false
}

allprojects {
    group = "net.kodein.themes"
    version = "4.3.0"
}

subprojects {
    afterEvaluate {
        extensions.findByType<PublishingExtension>()?.repositories {
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/kodeinkoders/kodein-themes")
                credentials {
                    username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_ACTOR")
                    password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
                }
            }
        }
    }
}
