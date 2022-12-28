import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.21"
    id("net.kyori.indra") version "2.1.1"
    id("net.kyori.indra.publishing") version "2.1.1"
    id("net.kyori.indra.checkstyle") version "2.1.1"
}

group = "com.simplymerlin"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {

}

indra {
    mitLicense()
    github("SimplyMerlin", "FSMChamp") {
        ci(true)
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}