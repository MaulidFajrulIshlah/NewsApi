package com.geminiboy.datastorageusingorm.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NoteViewModel(app : Application): AndroidViewModel(app) {

    lateinit var allNote : MutableLiveData<List<NoteData>>

    init{
        allNote = MutableLiveData()
        getAllNote()
    }
    fun getAllNoteObservers(): MutableLiveData<List<NoteData>> {
        return allNote
    }



    fun getAllNote() {
        GlobalScope.launch {
            val userDao = NoteDatabase.getInstance(getApplication())!!.noteDAO()
            val listnote = userDao.getDataNOte()
            allNote.postValue(listnote)
        }
    }
}
