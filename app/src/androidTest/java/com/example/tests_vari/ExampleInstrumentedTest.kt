package com.example.tests_vari

/* PERMESSI PER TESTING: GRANTPEERMISSIONRULE https://developer.android.com/reference/androidx/test/rule/GrantPermissionRule
  - @Rule @JvmField val grantPermissions = GrantPermissionRule.grant(
    android.Manifest.permission.ACCESS_FINE_LOCATION,
    android.Manifest.permission.ACCESS_COARSE_LOCATION,
    android.Manifest.permission.WRITE_EXTERNAL_STORAGE)

    richiedono questa dipendenza: androidTestImplementation 'com.android.support.test:rules:1.0.2'
 */

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.GrantPermissionRule

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Rule
    @JvmField
    val grantPermissions:GrantPermissionRule = GrantPermissionRule.grant(
        android.Manifest.permission.ACCESS_FINE_LOCATION,
        android.Manifest.permission.ACCESS_COARSE_LOCATION,
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.tests_vari", appContext.packageName)
    }

    @Test
    fun useAppContext2() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.tests_var", appContext.packageName)
    }
}