import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version Versions.springBoot
    id("io.spring.dependency-management") version Versions.springDependencyManager
    id("org.jetbrains.kotlin.jvm") version Versions.kotlinPlugin
    id("org.jetbrains.kotlin.plugin.spring") version Versions.kotlinPlugin
    id("org.jetbrains.kotlin.plugin.noarg") version Versions.kotlinPlugin
}

group = Constants.group

version = Versions.project

java {
    sourceCompatibility = JavaVersion.VERSION_17
}



repositories {
    mavenCentral()
}

dependencies {


    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    testImplementation("org.springframework.boot:spring-boot-starter-test")

    implementation(project(":data"))
    implementation(project(":presentation"))
    implementation(project(":domain"))

    //LomBok
    runtimeOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    //Thymeleaf
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
