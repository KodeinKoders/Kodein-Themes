plugins {
//    kotlin("jvm") version "1.7.10"
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(gradleApi())
    implementation(gradleKotlinDsl())
    implementation("org.asciidoctor:asciidoctorj:3.0.1")
    implementation("org.asciidoctor:asciidoctorj-pdf:2.3.23")
}
