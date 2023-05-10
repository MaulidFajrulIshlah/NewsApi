package com.geminiboy.gabut

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geminiboy.gabut.databinding.Activity3Binding
import com.geminiboy.gabut.databinding.Activity6Binding

class Activity6 : AppCompatActivity() {
    lateinit var binding : Activity6Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity6Binding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}