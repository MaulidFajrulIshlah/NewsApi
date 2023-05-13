package com.geminiboy.newsapi.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.geminiboy.newsapi.databinding.ActivitySourceBinding
import com.geminiboy.newsapi.view.adapter.SourceAdapter
import com.geminiboy.newsapi.viewmodel.SourceViewModel

class SourceActivity : AppCompatActivity() {
    lateinit var binding : ActivitySourceBinding
    lateinit var sourceAdapter: SourceAdapter
    lateinit var sourceVm : SourceViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySourceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sourceAdapter = SourceAdapter(ArrayList())

        sourceVm = ViewModelProvider(this).get(SourceViewModel::class.java)

        binding.rvSource.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val bundle = intent.extras
        val getCategory = bundle?.getString("name", "").toString()

        sourceVm.callApiSource(getCategory)
        binding.rvSource.adapter = sourceAdapter

        sourceVm.getDataSource().observe(this, Observer {
            if(it != null){
                sourceAdapter.setListSource(it)
            }
        })
    }
}