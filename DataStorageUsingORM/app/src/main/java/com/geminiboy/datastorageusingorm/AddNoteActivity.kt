package com.geminiboy.datastorageusingorm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geminiboy.datastorageusingorm.databinding.ActivityAddNoteBinding
import com.geminiboy.datastorageusingorm.room.NoteData
import com.geminiboy.datastorageusingorm.room.NoteDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class AddNoteActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddNoteBinding

    var noteDB : NoteDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)


        noteDB = NoteDatabase.getInstance(this)

        binding.btnSaveNote.setOnClickListener {
            addData()
        }
    }

    fun addData(){
        GlobalScope.async {
            var title = binding.noteTitle.text.toString()
            var content = binding.noteContent.text.toString()
            var tgl = binding.dateNote.text.toString()
            noteDB?.noteDAO()?.insertData(NoteData(0, title, content,tgl))
        }
        finish()
    }
}