import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version Versions.springBoot
	id("io.spring.dependency-management") version Versions.springDependencyManager
	kotlin("jvm") version Versions.kotlinPlugin
	kotlin("plugin.spring") version Versions.kotlinPlugin

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
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	//JPA
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")

	//H2-DB
	runtimeOnly("com.h2database:h2")

	//MySQL
	implementation("mysql:mysql-connector-java:${Versions.mysqlConnector}")

	//Validation
	implementation("org.springframework.boot:spring-boot-starter-validation")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

