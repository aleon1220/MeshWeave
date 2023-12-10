/*
 * file generated by Gradle 'init' task. @Incubating APIs subject to change
 */

 plugins {
    java
    // https://docs.gradle.org/8.5
    id("com.github.bjornvester.wsdl2java") version "2.0.2"
}

repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
}

dependencies {
  // GraphQL
  implementation("com.graphql-java-kickstart:graphql-webclient-spring-boot-starter:2.0.1")
  implementation("com.graphql-java:graphql-java:20.7")
  implementation("com.graphql-java-generator:graphql-java-runtime:1.18")  
}


wsdl2java {
    // https://plugins.gradle.org/plugin/com.github.bjornvester.wsdl2java
    // https://www.w3schools.com/xml/tempconvert.asmx?WSDL
    // wsdlDir.set(layout.projectDirectory.dir("src/main/resources/wsdl"))
    bindingFile.set(layout.projectDirectory.file("src/main/bindings/bindings.xjb"))

    includes.set(
        listOf(
        "src/main/resources/wsdl/NumberConversion.wsdl"
        )
    )
    // includesWithOptions.set(
    //     mapOf(
    //         "**/ServiceTemp.wsdl" to listOf("-wsdlLocation", "https://www.w3schools.com/xml/tempconvert.asmx?WSDL")
    //     )
    // )
    // default output directory $buildDir/generated/sources/wsdl2java/java
}