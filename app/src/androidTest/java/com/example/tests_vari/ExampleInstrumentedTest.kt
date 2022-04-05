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

import android.Manifest
import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.GrantPermissionRule
import org.junit.*

import org.junit.runner.RunWith

import org.junit.Assert.*
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

    //@Rule
    //var mRuntimePermissionRule = GrantPermissionRule.grant(Manifest.permission.WRITE_EXTERNAL_STORAGE)

    @Before
    fun inizializza(){
        nameTest="stringa iniziale"
    }

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
    fun scriviConsole(nomeTest: String){
        //Log.d("giuseppe", "lanciata scrittura in console")
        val context= InstrumentationRegistry.getInstrumentation().targetContext
        val path: File = context.getExternalFilesDir(null)!!
        //Log.d("giuseppe", "nome directory $path")
        val file = File(path, "giuseppe.txt")
        val stream = FileOutputStream(file)
        stream.use { stream ->
            stream.write("Nome del Test: $nomeTest".toByteArray())
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
    }

    @Test
    fun A_useAppContext() {
        nameTest= "useAppContext"
        try {
            // Context of the app under test.
            val appContext = InstrumentationRegistry.getInstrumentation().targetContext
            assertEquals("com.example.tests_vari", appContext.packageName)

            //una volta verificato si dovrebbe poter scrivere
            /*val context= InstrumentationRegistry.getInstrumentation().targetContext
            val path: File = context.getExternalFilesDir(null)!!
            Log.d("giuseppe", "nome directory $path")
            val file = File(path, "giuseppe.txt")
            val stream = FileOutputStream(file)
            stream.use { stream ->
                stream.write("Nome del Test: $nameTest".toByteArray())
            }*/
            scriviConsole("ecchime")
            //Log.d("giuseppe", "Test $nameTest riuscito!!!")
        }
        catch (exception: Exception){
            //Log.d("giuseppe", "Test $nameTest non riuscito!!! e ha generato una eccezione")
        }
    }

    //@Test
    fun useAppContextB() {
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

    @Test
    fun B_verificaLettura(){
        var letto = leggiConsole()
        //Log.d("giuseppeLettura", "letto dentro la funzione $letto")
        assertEquals("Nome del Test: ecchime", letto)
    }
}