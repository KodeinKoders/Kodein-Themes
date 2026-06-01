plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
    id("publish-convention")
    alias(libs.plugins.buildConfig)
}

repositories {
    mavenLocal()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(gradleApi())
    implementation(gradleKotlinDsl())
    implementation(libs.asciidoctorj)
    implementation(libs.asciidoctorj.pdf)
    implementation(libs.gradlePlugin.resourceFiles)
}

buildConfig {
    packageName("net.kodein.themes.adoc")
    buildConfigField("String", "VERSION", "\"${project.version}\"")
    useKotlinOutput {
        internalVisibility = true
    }
}

gradlePlugin {
    plugins {
        create("adoc") {
            id = "net.kodein.themes.adoc"
            implementationClass = "net.kodein.themes.adoc.AsciidoctorPlugin"
        }
    }
}
