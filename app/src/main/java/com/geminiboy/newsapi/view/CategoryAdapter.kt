package com.geminiboy.newsapi.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geminiboy.newsapi.databinding.ItemCategoryBinding
import com.geminiboy.newsapi.model.CategoryData

class CategoryAdapter(var listCategory : List<CategoryData>) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    class ViewHolder(var binding : ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(view)

    }


    override fun getItemCount(): Int {
        return listCategory.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.categoryName.text = listCategory[position].name
        Glide.with(holder.itemView).load(listCategory[position].picture).into(holder.binding.categoryImage)
    }
}