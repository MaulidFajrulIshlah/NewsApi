package com.geminiboy.gabut

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geminiboy.gabut.databinding.Activity2Binding
import com.geminiboy.gabut.databinding.ActivityMainBinding

class Activity2 : AppCompatActivity() {

    lateinit var binding : Activity2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tv2.setOnClickListener {
            val intent = Intent(this, Activity3::class.java)
            startActivity(intent)
        }
    }
}