package com.geminiboy.datastorageusingorm.room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geminiboy.datastorageusingorm.databinding.ItemNoteBinding

class NoteAdapter(var listNote : List<NoteData>):RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    var DBNote : NoteDatabase? = null
    class ViewHolder(var binding : ItemNoteBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapter.ViewHolder {
        var view = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  listNote.size
    }

    override fun onBindViewHolder(holder: NoteAdapter.ViewHolder, position: Int) {
        holder.binding.noteId.text = listNote[position].id.toString()
        holder.binding.noteTitle.text = listNote[position].content
        holder.binding.btnDeleteNote.setOnClickListener{
            DBNote = NoteDatabase.getInstance(it.context)



            }
        }

    fun setNoteData(listNote: ArrayList<NoteData>)
    {
        this.listNote=listNote
    }


}


