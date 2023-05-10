package com.geminiboy.datastorageusingorm.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity

data class NoteData (
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var title : String,
    var content : String,
    var date : String
        )