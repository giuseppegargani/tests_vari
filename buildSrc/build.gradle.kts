/* Spiegazione:
 - Si crea una directory (crea directory) src/main/java   !!!!!
 */

//per questo file si deve ogni volta fare la sync!!!!!!!

plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

abstract class SalutiTask : DefaultTask() {
    @TaskAction
    fun greet() {
        println("Ciao da kotlin!!!!!")
    }
}

// Create a task using the task type
tasks.register<SalutiTask>("saluti")

tasks.register("giuseppe"){
    println("eccomi qui belli!!!!")
}