import kotlinx.benchmark.gradle.JvmBenchmarkTarget

plugins {
    kotlin("jvm") version "1.8.21"
    // Kotlin Serialization
    kotlin("plugin.serialization") version "1.8.21"

    // Moshi Serialization
    id("com.google.devtools.ksp").version("1.6.10-1.0.4")

    // Benchmark
    id("org.jetbrains.kotlinx.benchmark").version("0.4.8")
    id("org.jetbrains.kotlin.plugin.allopen").version("1.8.21")
    id("me.champeau.jmh").version("0.7.1")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

allOpen {
    annotation("org.openjdk.jmh.annotations.State")
}

dependencies {
    testImplementation(kotlin("test"))

    // Kotlin Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")

    // Moshi Serialization
    implementation("com.squareup.moshi:moshi-kotlin:1.14.0")
    implementation("com.squareup.moshi:moshi-adapters:1.14.0")
    ksp("com.squareup.moshi:moshi-kotlin-codegen:1.14.0")

    // Gson
    implementation("com.google.code.gson:gson:2.10.1")

    testImplementation("org.jetbrains.kotlinx:kotlinx-benchmark-runtime:0.4.8")
    testImplementation("org.openjdk.jmh:jmh-core:1.21")
    testAnnotationProcessor("org.openjdk.jmh:jmh-generator-annprocess:1.10.2")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    sourceSets {
        main {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-benchmark-runtime:0.4.8")
            }
        }
    }
}

benchmark {
    configurations {
        named("main") {
            iterationTime = 5
            iterationTimeUnit = "sec"

        }
    }
    targets {
        register("main") {
            this as JvmBenchmarkTarget
            jmhVersion = "1.21"
        }
    }
}