package com.geminiboy.fragment

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.geminiboy.fragment.databinding.ActivityContainerBinding
import com.geminiboy.fragment.databinding.ActivityMainBinding

class Container : AppCompatActivity() {

    lateinit var binding : ActivityContainerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContainerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .add(R.id.frContainer, Fragment1()).
                commit()
        }

        binding.btn2.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .add(R.id.frContainer, Fragment2()).
                commit()
        }




    }

    override fun onStop() {
        super.onStop()
        Log.d("lifeFragment", "onStop")
    }
    override fun onStart() {
        super.onStart()
        Log.d("lifeFragment", "onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d("lifeFragment", "onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.d("lifeFragment", "onResume")
    }
}