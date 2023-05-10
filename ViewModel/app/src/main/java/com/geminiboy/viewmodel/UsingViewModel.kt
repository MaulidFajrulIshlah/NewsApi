package com.geminiboy.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.zfuncode.viewmodeltopicsatu.HitungViewModel

class UsingViewModel : AppCompatActivity() {
    lateinit var btnHitung : Button
    lateinit var etPanjang : EditText
    lateinit var etLebar : EditText
    lateinit var etTinggi : EditText
    lateinit var txtHasil : TextView
    lateinit var viewModel : HitungViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_using_view_model)

        btnHitung= findViewById(R.id.btnHitung)
        etPanjang = findViewById(R.id.etPanjang)
        etLebar = findViewById(R.id.etLebar)
        etTinggi = findViewById(R.id.etTinggi)
        txtHasil = findViewById(R.id.txtHasil)

        viewModel = ViewModelProvider(this).get(HitungViewModel::class.java)
        txtHasil.text = viewModel.hasil.toString()
//        displayResult()

        btnHitung.setOnClickListener{
            var pj = etPanjang.text.toString().toInt()
            var lb = etLebar.text.toString().toInt()
            var tg = etTinggi.text.toString().toInt()
            viewModel.Hitung(pj,lb,tg)
            txtHasil.text = viewModel.hasil.toString()
        }


    }

    fun displayResult(){
        txtHasil.text = viewModel.hasil.toString()
    }
}