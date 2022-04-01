package com.example.tests_vari

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.tests_vari.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var helloText: TextView
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        helloText = binding.helloText
        helloText.text = "accidenti".toString()

        //si legge il dato da un file xml!!!!

    }
}