package com.geminiboy.datastorageusingorm.room

import androidx.core.graphics.PathParser.PathDataNode
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDAO {
    @Insert
    fun insertData(noteData: NoteData)

    @Query("SELECT * FROM NoteData ORDER BY id DESC")
    fun getDataNOte() : List<NoteData>
}