package com.geminiboy.gabut

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geminiboy.gabut.databinding.Activity3Binding
import com.geminiboy.gabut.databinding.Activity4Binding

class Activity4 : AppCompatActivity() {
    lateinit var binding : Activity4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity4Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tv4.setOnClickListener {
            val intent = Intent(this, Activity5::class.java)
            startActivity(intent)
        }
    }
}