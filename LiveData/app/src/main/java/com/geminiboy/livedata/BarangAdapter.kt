package com.geminiboy.livedata

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geminiboy.livedata.databinding.ItemBarangBinding

class BarangAdapter(var listProduk : ArrayList<ListBarang>): RecyclerView.Adapter<BarangAdapter.ViewHolder>() {
    class ViewHolder(var binding : ItemBarangBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindProduk(itemData : ListBarang){
            binding.produk = itemData
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarangAdapter.ViewHolder {
        var view = ItemBarangBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: BarangAdapter.ViewHolder, position: Int) {
//        var dataProduk = listProduk[position]
        holder.bindProduk(listProduk[position])
    }

    override fun getItemCount(): Int {
        return listProduk.size
    }

    fun getDataProduk(itemProduk : ArrayList<ListBarang>){
        this.listProduk = itemProduk
    }
}