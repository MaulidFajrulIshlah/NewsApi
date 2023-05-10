package com.geminiboy.tugasviewmodel.recylerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.geminiboy.tugasviewmodel.R
import java.util.ArrayList

class StudentAdapter(var listStudent : ArrayList<DataStudent>):RecyclerView.Adapter<StudentAdapter.ViewHolder>() {



    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        var name = itemView.findViewById<TextView>(R.id.movieName)
        var durasi = itemView.findViewById<TextView>(R.id.durasi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var data = listStudent[position]
        holder.name.text = data.name
        holder.durasi.text = data.durasi
    }

    override fun getItemCount(): Int {
        return listStudent.size
    }

    fun setStudentData(listStudent: ArrayList<DataStudent>)
    {
        this.listStudent=listStudent
    }
}