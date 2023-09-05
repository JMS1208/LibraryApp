import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.1.2"
    id("io.spring.dependency-management") version "1.1.3"
    id("org.jetbrains.kotlin.jvm") version "1.8.22"
    id("org.jetbrains.kotlin.plugin.spring") version "1.8.22"
    id("org.jetbrains.kotlin.plugin.noarg") version "1.8.10"
}

group = "com.minseok"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {

    implementation("mysql:mysql-connector-java:8.0.32")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation(project(":data"))

    //JPA
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    //H2-DB
    runtimeOnly("com.h2database:h2")

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
