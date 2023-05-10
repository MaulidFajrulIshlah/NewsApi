package com.geminiboy.gabut

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geminiboy.gabut.databinding.Activity3Binding
import com.geminiboy.gabut.databinding.Activity5Binding

class Activity5 : AppCompatActivity() {
    lateinit var binding : Activity5Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity5Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tv5.setOnClickListener {
            val intent = Intent(this, Activity6::class.java)
            startActivity(intent)
        }
    }
}