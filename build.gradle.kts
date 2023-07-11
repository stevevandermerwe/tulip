/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin application project to get you started.
 */

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

plugins {

    // Add support for AsciidoctorJ
    id("org.asciidoctor.jvm.convert") version "3.3.2"

    // Apply the Kotlin JVM plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.8.22"

    // Apply the application plugin to add support for building a CLI application.
    application
}

repositories {
    // Use jcenter for resolving dependencies.
    // You can declare any Maven/Ivy/file repository here.
    mavenCentral()
}

dependencies {
    // Include JAR files in libs folder
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    //implementation("org.jetbrains.kotlin:kotlin-stdlib")

    implementation(platform("org.http4k:http4k-bom:4.39.0.0"))
    implementation("org.http4k:http4k-core")
    implementation("org.http4k:http4k-client-apache")
    implementation("org.http4k:http4k-server-undertow")
    implementation("org.http4k:http4k-serverless-lambda")

    // okhttp
    implementation("com.squareup.okhttp3:okhttp:4.10.0")

    // JSON Kotlin Parser.
    implementation("com.beust:klaxon:5.6")

    // Conversant disruptor - https://github.com/conversant/disruptor
    implementation("com.conversantmedia:disruptor:1.2.21")

    // LMAX disruptor - https://github.com/LMAX-Exchange/disruptor
    implementation("com.lmax:disruptor:4.0.0.RC1")

    // Use the Kotlin test library.
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // Use the Kotlin JUnit integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}


application {
    // Default JVM settings

    // G1GC (default), Java 11
    applicationDefaultJvmArgs = listOf("-server", "-Xmx4096m", "-XX:+UseG1GC", "-XX:+ParallelRefProcEnabled", "-XX:+UseDynamicNumberOfGCThreads")
    // applicationDefaultJvmArgs = listOf("-server", "-Xms4096m", "-Xmx4096m", "-XX:+UseG1GC", "-XX:+ParallelRefProcEnabled", "-XX:+UseDynamicNumberOfGCThreads", "-javaagent:./runtime/glowroot/glowroot.jar")

    // applicationDefaultJvmArgs = listOf("-server", "-Xms4096m", "-Xmx4096m", "-XX:+UseZGC", "-XX:+UseDynamicNumberOfGCThreads")
    // applicationDefaultJvmArgs = listOf("-server", "-Xmx4096m", "-Xmx4096m", "-XX:+UseShenandoahGC")
    // applicationDefaultJvmArgs = listOf("-server", "-Xmx4096m", "-Xmx4096m", "-XX:+UseParallelGC")

    // Java 8
    //, "-XX:+UseParallelGC")

    // Define the main class for the application
    mainClass.set("LoadTest1")
}
