plugins {
    java
    id("org.springframework.boot") version ("2.7.1")
    id("io.spring.dependency-management") version ("1.0.11.RELEASE")
    id("org.flywaydb.flyway") version ("8.2.0")
    id("io.freefair.lombok") version ("6.5.1")
    id("com.epages.restdocs-api-spec") version ("0.16.2")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

allprojects {
    group = "com.wesang"

    repositories {
        mavenCentral()
    }
}

dependencies {
    apply(plugin = "java")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "io.freefair.lombok")


        implementation("org.springframework.boot:spring-boot-starter-actuator")
        implementation("org.springframework.boot:spring-boot-starter-validation")
        implementation("org.springframework.boot:spring-boot-starter-webflux")
        implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")

        implementation("org.codehaus.janino:janino")
        implementation("org.apache.commons:commons-lang3")
        implementation("com.google.guava:guava:31.1-android")
        implementation("org.springframework.boot:spring-boot-starter-actuator")
        implementation("commons-io:commons-io:2.11.0")
        implementation("ch.qos.logback.contrib:logback-jackson:0.1.5")
        implementation("ch.qos.logback.contrib:logback-json-classic:0.1.5")
        implementation("commons-codec:commons-codec:1.15")

        annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("com.epages:restdocs-api-spec-mockmvc:0.16.2")
        testImplementation("org.jeasy:easy-random-core:5.0.0")
        testImplementation("org.testcontainers:testcontainers:1.17.5")
        testImplementation("org.testcontainers:junit-jupiter:1.17.5")
        testImplementation("org.testcontainers:mysql:1.17.5")

        testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")

    tasks.withType<Test> {
        useJUnitPlatform()
    }
    implementation("mysql:mysql-connector-java")
}

flyway {
    configFiles = arrayOf("${projectDir}/flyway.conf")
}

tasks {
    bootJar {
        enabled = false
    }
}
