package com.geminiboy.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.geminiboy.livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var adapterProduk : BarangAdapter
    lateinit var produkViewMode: ProductViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        produkViewMode = ViewModelProvider(this).get(ProductViewModel::class.java)
        adapterProduk = BarangAdapter(ArrayList())

        produkViewMode.getData()
        produkViewMode.productVm.observe(this, Observer {
            adapterProduk.getDataProduk(it as ArrayList<ListBarang>)
        })


        binding.rvProduk.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL,false)
        binding.rvProduk.adapter = adapterProduk
    }
}