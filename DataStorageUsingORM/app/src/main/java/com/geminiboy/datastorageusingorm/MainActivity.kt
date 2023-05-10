package com.geminiboy.datastorageusingorm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.geminiboy.datastorageusingorm.databinding.ActivityMainBinding
import com.geminiboy.datastorageusingorm.room.NoteAdapter
import com.geminiboy.datastorageusingorm.room.NoteData
import com.geminiboy.datastorageusingorm.room.NoteDatabase
import com.geminiboy.datastorageusingorm.room.NoteViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var noteAdapter: NoteAdapter
    var noteDB : NoteDatabase? = null
    private lateinit var noteViewModel : NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        noteDB = NoteDatabase.getInstance(this)

        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        noteViewModel.getAllNote()

        noteVM()

        noteViewModel.getAllNoteObservers().observe(this, Observer {
            noteAdapter.setNoteData(it as ArrayList<NoteData>)
        })

        binding.btnAdd.setOnClickListener{
            startActivity(Intent(this,AddNoteActivity::class.java))
        }
    }

    private fun noteVM() {
        noteAdapter = NoteAdapter(ArrayList())
        binding.rvNote.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvNote.adapter = noteAdapter
        noteAdapter.notifyDataSetChanged()
    }

    fun getAllNote(){

        GlobalScope.launch {
            var data = noteDB?.noteDAO()?.getDataNOte()
            runOnUiThread{
                noteAdapter = NoteAdapter(data!!)
                binding.rvNote.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
                binding.rvNote.adapter = noteAdapter
            }
        }

    }
}