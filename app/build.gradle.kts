import BuildPlugins.android
import ConfigData.versionName

/* CONCETTI
 - Android ufficiale:  Opzioni di test avanzate!!! https://developer.android.com/studio/test/advanced-test-setup

 - Si puo' cambiare anche la directory dove vengono salvati i risultati dei tests: (vedi sopra)

 - Opzioni di textInstrumentalRunner: https://medium.com/stepstone-tech/exploring-androidjunitrunner-filtering-options-df26d30b4f60

 - Annotazioni: https://pspdfkit.com/blog/2020/filtering-tests-in-android/

 - 6 MIGLIORI TUTORIALS PER GRADLE!!!! https://tomgregory.com/best-gradle-tutorials-for-beginners/

 - se dentro ad unitTests.all di mette filter {includeTestsMatching "ExampleUnitTest.primo_test"}   esegue solo il primo test (esempio)  !!!!!! e si possono cercare i test che si vuole!!!!

 - esempio filter: https://docs.gradle.org/current/javadoc/org/gradle/api/tasks/testing/TestFilter.html

 - Si puo' generare un file xml per i test CI

 - Documentazione TestLogging: https://docs.gradle.org/current/javadoc/org/gradle/api/tasks/testing/logging/TestLoggingContainer.html

 - permessi per le azioni: https://docs.github.com/en/actions/using-jobs/assigning-permissions-to-jobs

 - scrivere tests for librerie android!!!!! https://medium.com/geekculture/write-your-tests-for-your-android-libraries-and-plugins-3ec4b5da2faf

 - testare una build con testKit https://docs.gradle.org/current/userguide/test_kit.html

 - Ci vuole il test dei plugin e dei tasks!!!! vedi documentazione ufficiale!!!!

 -- Come si modificano Tasks di un certo tipo????

 - pubblicare i risultati dei tuoi tests: https://github.com/marketplace/actions/publish-unit-test-results

 - Articolo molto interessante su DAG e diversi momenti di esecuzione!!!!!!!!!! https://www.devopsschool.com/blog/what-is-gradle-dag-directed-acyclic-graph/

 - Come si aggiunge una task ad un subproject (mettendo apply e il plugin!!!) https://stackoverflow.com/questions/44943330/adding-gradle-task-to-a-subproject-in-method

 - Come si inseriscono tasks dentro un subproject!!! https://discuss.gradle.org/t/gradle-task-in-subproject/23071
   Come si vede con la task cavolino (che non ha dipendenze) e stampa in console!!!! e fa' parte del subproject :app    !!!!

 - Tutorial su come leggere un file xml: https://www.youtube.com/watch?v=ew09HvT01MQ

 - AGGREGARE TESTS. C'e' un plugin per github actions? come in locale https://docs.gradle.org/current/userguide/test_report_aggregation_plugin.html#test_report_aggregation_plugin

 - Si puo' modificare la directory dove si salvano i risultati modificando delle variabili
    reporting.baseDir = "my-reports"
    testResultsDirName = "$buildDir/my-test-results"

 - Si puo' registrare una task che visualizza dove sono stati salvati
    logger.quiet(rootDir.toPath().relativize(project.reportsDir.toPath()).toString())
    logger.quiet(rootDir.toPath().relativize(project.testResultsDir.toPath()).toString())

 - Si possono invocare in github action delle task che sono state sviluppate in locale (per esempio quella che mostra il percorso di salvataggio dei file)

 - Per visualizzare un file XML basta spostarlo in un browser

 - Come si vede andando sul sito di CodeBeautify si puo' convertire xml in json (sul browser) ma penso anche impostando qualche cosa in gradle  (pronti per firebase)

 - tutorial su come lavorare su xml in groovy: https://www.baeldung.com/groovy-xml

 - si importa Groovy-all     implementation 'org.codehaus.groovy:groovy-all:2.4.15'

 - Si puo' usare Ant

 - Gradle dependency management: https://www.youtube.com/watch?v=w5qCmvS9JGE
   articolo: https://pspdfkit.com/blog/2018/moving-your-gradle-build-scripts-to-kotlin/
   altro video youtube: https://www.youtube.com/watch?v=zVml1aua9AE
   articolo medium: https://proandroiddev.com/better-dependencies-management-using-buildsrc-kotlin-dsl-eda31cdb81bf

 - Parse XML
    https://www.baeldung.com/groovy-xml

 - Si possono convertire i risultati direttamente in json (per impostazioni di gradle)? sarebbe perfino meglio!!!!

 - Migrazione a Kotlin (per build) da preferirsi!!!!! https://developer.android.com/studio/build/migrate-to-kts
   Sempre Gradle ma con Kotlin!!!! documentazione ufficiale: https://docs.gradle.org/nightly/userguide/migrating_from_groovy_to_kotlin_dsl.html#applying_plugins

 - ARTICOLO STORICO SU JUNIT TEST: https://github.com/sarven/unit-testing-tips !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

 - Ci sono github actions che convertono leggono XML? o convertono in Json? (marketPlace)  https://github.com/search?q=convert+xml+in+json

 - Lettore di XML per github actions!!! https://github.com/marketplace/actions/get-xml-info  !!!!!

 - Ma si puo' anche convertire HTML in Json se si ritiene opportuno!!!

 - Ma le actions sono pubbliche e si puo' leggere il codice con cui sono fatte!!!

 - Possibile leggere valori, e salvarli come artifact e zip!!!     https://github.com/marketplace/actions/get-xml-info

 - Dopo test il percorso e' il seguente: 'app/build/test-results/testDebugUnitTest' e i files sono   (a seconda dei file presenti!!!!)
    TEST-com.example.tests_vari.ExampleSecondUnitTest.xml
    TEST-com.example.tests_vari.ExampleUnitTest.xml

 - per dare comando di listare una directory con github actions: Run ls 'app/build/test-results/testDebugUnitTest'

 - Per eseguire uno step anche se il precedente ha fallito: https://stackoverflow.com/questions/58858429/how-to-run-a-github-actions-step-even-if-the-previous-step-fails-while-still-f
    CI SONO TANTISSIMI CASI!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    CONTINUE ON ERROR!!!

 - Le credenziali di FIREBASE_CREDENTIALS  (che vengono date in automatico) sono l'unico dato necessario e devono essere inserite (come segreto) comprensive delle parentesi grafe!!!!!!!
    Si puo' segnare anche un percorso di salvataggio dei dati

 - Github action che converte da xml in json https://github.com/marketplace/actions/yaml-json-xml-converter-action

 - importare dipendenze esterne: https://stackoverflow.com/questions/25660166/how-to-add-a-jar-in-external-libraries-in-android-studio

 - TUTORIALSPOINT SU GROOVY ha spiegazione e PLAYGROUND!!!!!!!!  https://www.tutorialspoint.com/groovy/groovy_closures.htm

 - Creare una libreria android (documentazione ufficiale) https://developer.android.com/studio/projects/android-library

 - Sito con tantissime spiegazioni su groovy!!!! https://code-maven.com/groovy-json

 - ESPRESSIONI CONDIZIONALI IN GITHUB ACTIONS!!!!!! sono molto interessanti!!!! if()

 - come lavorare con gradle Logger: https://stackoverflow.com/questions/3963708/gradle-how-to-display-test-results-in-the-console-in-real-time!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    e creare una libreria in android!!!

 - GRADLE 7.0 Migliorato la situazione!!!!1 https://gradle.org/whats-new/gradle-7/  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! vedere le caratteristiche!!!!!!

 - BUILDSRC!!!! interessante (sembra complementare a Build.gradle)!!!! https://proandroiddev.com/better-dependency-management-in-android-studio-3-5-with-gradle-buildsrcversions-7cd67dbaa5d4   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 */

/* Aggiustamenti per singolo file di build!!!!! https://docs.gradle.org/current/userguide/migrating_from_groovy_to_kotlin_dsl.html
    - plugins: solo il nome oppure backtick se il nome e' composto
    - minifyEnabled diventa isMinifyEnable => minifyEnabled is a property with name isMinifyEnabled.
        https://medium.com/mindorks/migrating-gradle-build-scripts-to-kotlin-dsl-89788a4e383a
      significato: removes dead code but does not obfuscate or optimize!!!!!!!

    - proguardFiles and getDefaultProguardFile are functions.  Diventa nel modo seguente:
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")

    - sourceCompatibility = JavaVersion.VERSION_1_8

    - jvmTarget = https://stackoverflow.com/questions/55456176/unresolved-reference-compilekotlin-in-build-gradle-kts
        tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }

    - implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
      https://stackoverflow.com/questions/54166069/how-do-you-add-local-jar-file-dependency-to-build-gradle-kt-file
      modo idiomatico in groovy!!!!!!!!!!!!!!!!!!!!!!!
 */

plugins {
    id ("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    //compileSdk
    compileSdkVersion(32)

    defaultConfig {
        applicationId = "com.example.tests_vari"
        minSdk = 24
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        dataBinding = true
    }
    packagingOptions {
        resources{
            excludes.add("META-INF/DEPENDENCIES")
            excludes.add("META-INF/LICENSE")
            excludes.add("META-INF/LICENSE.txt")
            excludes.add("META-INF/license.txt")
            excludes.add("META-INF/NOTICE")
            excludes.add("META-INF/NOTICE.txt")
            excludes.add("META-INF/notice.txt")
            excludes.add("META-INF/ASL2.0")
            excludes.add("METS-INF/INDEX.LIST")
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
    /*kotlinOptions {
        jvmTarget = '1.8'
    }*/

    //qui che vanno messi i cambi di configurazione di test!!!!
    /*testOptions {
        unitTests.all {
            filter {
                //se si mette il seguente esegue solo il primo test (da linea di comando e build!!!)
                includeTestsMatching "ExampleUnitTest.primo_test"
                //fa' tutti i primi test delle due classi (oppure con Regex!!!)
                //includeTestsMatching "*.primo_test"
            }
            testLogging {
                //serve per stampare in console i risultati relativi ai seguenti eventi (verificato)
                events "passed", "skipped", "failed", "standardOut", "standardError"
            }
        }
    }*/
    //questa task copia
    /*task helloandroid(type: Copy) {
        //si puo' mettere anche che dipende dalla build!!!! ma in questo caso non e' necessario!!!!!!!!!
        //dependsOn build
        doLast {  // or doFirst depending on the behaviour you want
            new File("C:/Users/giuse/Documents/Example.txt").eachLine {
                line -> println "line : $line";
            }
        }
    }*/
    //questa task stampa in console (e non ha dipendenze)!!!!!!!
    /*task cavolino(){
        doLast {
            println('eccomi qui!!!!')
        }
    }

    //questa prova a rilanciare il test
    task rilanciatest(){
        dependsOn build
        doLast {
            println('accidempolina')
        }
    }*/

    //giuseppe
    /*configurations {
        groovy
    }
    //giuseppe
    dependencies {
        groovy 'org.apache.groovy:groovy-all:4.0.0'
    }
    //giuseppe
    task downloadGroovy2(type: Copy) {
        from configurations.groovy
        into file('groovy-xml-4.0.0.jar')
    }*/
    //Si modificano queste variabili per modificare il percorso di salvataggio dei risultati
    //reporting.baseDir = "my-reports"
    //testResultsDirName = "$buildDir/my-test-results"

    //per visualizzare la directory di salvataggio dei files !!!!!!!!!
    /*tasks.register('showDirs') {
        doLast {
            println project
            def progetto = project
            logger.quiet(rootDir.toPath().relativize(project.reportsDir.toPath()).toString())
            logger.quiet(rootDir.toPath().relativize(project.testResultsDir.toPath()).toString())
        }
    }*/

    //per convertire in txt
    //build.gradle
    /*task transformXml {
        ext.srcFile = file('mountains.xml')
        ext.destDir = new File(buildDir, 'generated')
        inputs.file srcFile
        outputs.dir destDir
        doLast {
            println "trasforma il file"
            destDir.mkdirs()
            def mountains = new XmlParser().parse(srcFile)
            mountains.mountain.each { mountain ->
                def name = mountain.name[0].text()
                def height = mountain.height[0].text()
                //def destFile = new File(destDir, "${name}.txt")
                //destFile.text = "$name -> ${height}\n"
                println(name)
                println(height)
            }
        }
    }*/
}

dependencies {

    implementation ("androidx.core:core-ktx:1.7.0")
    implementation ("androidx.appcompat:appcompat:1.4.1")
    implementation ("com.google.android.material:material:1.5.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.3")
    //implementation files('libs\\groovy-json-4.0.0.jar')
    //implementation files('libs\\groovy-xml-4.0.0.jar')
    testImplementation ("junit:junit:4.+")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")

    //implementation 'org.codehaus.groovy:groovy-all:2.4.15'
    //localGroovy()
    // Add this line if was not added before.
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    //implementation fileTree(dir: 'libs', include: ['*.jar'])
    //implementation files('libs/groovy-json-4.0.0.jar')
    //implementation files('libs/groovy-xml-4.0.0.jar')
    implementation("org.codehaus.groovy:groovy:2.4.0:grooid")
}

