package com.geminiboy.gabut

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geminiboy.gabut.databinding.Activity2Binding
import com.geminiboy.gabut.databinding.Activity3Binding

class Activity3 : AppCompatActivity() {
    lateinit var binding : Activity3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tv3.setOnClickListener {
            val intent = Intent(this, Activity4::class.java)
            startActivity(intent)
        }
}
}