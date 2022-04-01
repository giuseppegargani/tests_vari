package com.example.tests_vari

import org.junit.Test

import org.junit.Assert.*

/* https://www.baeldung.com/gradle-test-vs-check
 */

/* Vede correttamente anche gli altri test!!! e ne rende il resoconto!!

 */

class ExampleUnitTest {
    @Test
    fun primo_test() {
        assertEquals(4, 2 + 2)
    }

    //il secondo test e' sbagliato
    //@Test
    fun secondo_test() {
        assertEquals(4, 3 + 2)
    }

    //il terzo test pure e' sbagliato
    //@Test
    fun terzo_test(){
        assertEquals(4, 3 + 5)
    }

    //questo test e' corretto
    @Test
    fun quarto_test(){
        assertEquals(7, 3 + 4)
    }

}