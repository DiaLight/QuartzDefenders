plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.3.40"
}

group = "quartz-defenders"
//version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
    maven("https://jitpack.io/") { name = "jitpack-repo" }
    maven("https://repo.destroystokyo.com/repository/maven-public/") { name = "destroystokyo-repo" }
    maven("https://hub.spigotmc.org/nexus/content/groups/public/") { name = "spigotmc-repo" }
    maven("https://oss.sonatype.org/content/groups/public/") { name = "sonatype-repo" }
    mavenLocal()
}

dependencies {
    implementation("org.spigotmc:spigot-api:1.12.2-R0.1-SNAPSHOT")
    implementation("org.apache.commons:commons-lang3:3.9")
    implementation("commons-io:commons-io:2.6")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testCompile("junit:junit:4.12")
}

