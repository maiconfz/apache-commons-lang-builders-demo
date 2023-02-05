plugins {
    application
    java
	id("org.springframework.boot") version "3.0.2"
	id("io.spring.dependency-management") version "1.1.0"
    id("io.freefair.lombok") version "6.6.1"
}

group = "io.github.maiconfz"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.apache.commons:commons-lang3:3.12.0")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
    
}

application {
    mainClass.set("io.github.maiconfz.apache_commons_lang_builders_demo.App")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
