plugins {
    kotlin("jvm") version "2.2.0"
    application
}

group = "com.example.kotlinandroid"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
    
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
    testImplementation("junit:junit:4.13.2")
}

application {
    mainClass.set("com.example.kotlinandroid.MainKt")
}

tasks.test {
    useJUnit()
}

kotlin {
    jvmToolchain(17)
}