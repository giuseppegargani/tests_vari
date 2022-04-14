package com.example.tests_vari

/* PERMESSI PER TESTING: GRANTPEERMISSIONRULE https://developer.android.com/reference/androidx/test/rule/GrantPermissionRule
  - @Rule @JvmField val grantPermissions = GrantPermissionRule.grant(
    android.Manifest.permission.ACCESS_FINE_LOCATION,
    android.Manifest.permission.ACCESS_COARSE_LOCATION,
    android.Manifest.permission.WRITE_EXTERNAL_STORAGE)

    richiedono questa dipendenza: androidTestImplementation 'com.android.support.test:rules:1.0.2'
 */

/* SI DEVONO METTERE PER ORDINE!!! con una lettera davanti

 */

/* SI METTE UN TEMPO DI INIZIO DEL CONTEGGIO E UNO DI CHIUSURA E SI SALVANO I DATI DA QUALCHE PARTE!!!
*/

/*Si possono salvare i dati con la concatenazione di eventi, oppure in qualsiasi altro modo
  anche assegnando variabili a gradle in github action!!!! e poi andando a mandarle su firebase
  Ogni processo su github ha delle variabili
*/

/* Gradle opera su Macos (o Linux) e il salvataggio deve essere fatto inviando dati al sistema operativo su cui gira android studio
    - Gradle in github actions (e' quello che lavora su sistema operativo della macchina virtuale), mentre adb lavora su emulatore
    - si dovrebbe poter leggere i dati da adb!!! e immagazzinarli (come si fa' in locale) !!!
    - con gradle si possono salvare i dati (restituiti da Adb)
 */

// SI DEVE METTERE UN SALVATAGGIO FINALE (AFTER)!!!!!dei file!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! e occhio a config di non azzerare macchina dopo ogni test!!!!!!!!!

/* TESTWATCHER!!!
  - https://www.baeldung.com/junit-testwatcher
  - https://junit.org/junit4/javadoc/4.12/org/junit/rules/TestWatcher.html
  - https://junit.org/junit4/javadoc/latest/org/junit/rules/TestWatcher.html
  - https://stackoverflow.com/questions/473401/get-name-of-currently-executing-test-in-junit-4

 */




import android.Manifest
import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.GrantPermissionRule
import org.junit.*

import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.rules.TestRule
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.junit.runners.MethodSorters
import java.io.File
import java.lang.Exception
import java.io.FileOutputStream
import java.io.FileReader


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class ExampleInstrumentedTest {
    private lateinit var nameTest: String

    @Rule
    var watcher: TestRule = object : TestWatcher() {
        protected override fun starting(description: Description) {
            System.out.println("********************************* Starting test: " + description.getMethodName())
        }
    }

    //@Rule
    //var mRuntimePermissionRule = GrantPermissionRule.grant(Manifest.permission.WRITE_EXTERNAL_STORAGE)

    //rimettere!!!!!!!!!!!!!!!!!!!
    /*@Before
    fun inizializza(){
        nameTest="stringa iniziale"
    }*/

    //var nameTest: MutableList<String> = mutableListOf()

    //@After
    //fun scritta() { Log.d("giuseppe", "il nome del test passato e' $nameTest") }

    /*@Rule
    @JvmField
    val grantPermissions:GrantPermissionRule = GrantPermissionRule.grant(
        android.Manifest.permission.ACCESS_FINE_LOCATION,
        android.Manifest.permission.ACCESS_COARSE_LOCATION,
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE)*/

    //questa funzione scrive in console sulla base della stringa ed evento
    /*fun scriviConsole(nomeTest: String, boolean: Boolean = true){
        //Log.d("giuseppe", "lanciata scrittura in console")
        val context= InstrumentationRegistry.getInstrumentation().targetContext
        val path: File = context.getExternalFilesDir(null)!!
        //Log.d("giuseppe", "nome directory $path")
        val file = File(path, "giuseppe.txt")
        val stream = FileOutputStream(file)
        stream.use { stream ->
            stream.write("$nomeTest  success \n".toByteArray())
        }
    }

    fun leggiConsole():String{
        //Log.d("giuseppe", "lanciata lettura in console")
        val context= InstrumentationRegistry.getInstrumentation().targetContext
        val path: File = context.getExternalFilesDir(null)!!
        //Log.d("giuseppe", "nome directory $path")
        val file = File(path, "giuseppe.txt")
        /*val stream = FileOutputStream(file)
        stream.use { stream ->
            stream.write("Nome del Test: $nomeTest".toByteArray())
        }*/

        val reader = FileReader(file)
        val txt = reader.readText()
        //Log.d("giuseppeLettura", "****** stringa letta $txt")
        reader.close()
        return txt
    }*/

    @Test
    fun A_useAppContext() {
        nameTest= "useAppContext"
        try {
            // Context of the app under test.
            val appContext = InstrumentationRegistry.getInstrumentation().targetContext
            assertEquals("com.example.tests_vari", appContext.packageName)

            //una volta verificato si dovrebbe poter scrivere
            val context= InstrumentationRegistry.getInstrumentation().targetContext
            val path: File = context.getExternalFilesDir(null)!!
            Log.d("giuseppe", "nome directory $path")
            val file = File(path, "giuseppe.txt")
            val stream = FileOutputStream(file)
            stream.use { stream ->
                stream.write("A_useAppContextTest successo".toByteArray())
            }
            //scriviConsole("A_useAppContextTest")
            //Log.d("giuseppe", "Test $nameTest riuscito!!!")
        }
        catch (exception: Exception){
            //Log.d("giuseppe", "Test $nameTest non riuscito!!! e ha generato una eccezione")
        }
    }

    //@Test
    /*fun useAppContextB() {
        nameTest+= "useAppContextB"
        try {
            // Context of the app under test.
            val appContext = InstrumentationRegistry.getInstrumentation().targetContext
            assertEquals("com.example.tests_vari", appContext.packageName)
            Log.d("giuseppe", "Test $nameTest riuscito!!!")
        }
        catch (exception: Exception){
            Log.d("giuseppe", "Test $nameTest non riuscito!!! e ha generato una eccezione")
        }
    }

    //@Test
    fun useAppContext2() {
        nameTest+="useAppContext2"
        // Context of the app under test.
        try {
            // Context of the app under test.
            val appContext = InstrumentationRegistry.getInstrumentation().targetContext
            assertEquals("com.example.tests_vari", appContext.packageName)
            nameTest.map { it -> Log.d("giuseppe", " test $it") }
        }
        catch (exception: Exception){
            //Log.d("giuseppe", "Test $nameTest non riuscito!!! e ha generato una eccezione")
        }
    }

    //@Test
    fun B_verificaLettura(){
        var letto = leggiConsole()
        //Log.d("giuseppeLettura", "letto dentro la funzione $letto")
        assertEquals("Nome del Test: ecchime", letto)
    }*/
}