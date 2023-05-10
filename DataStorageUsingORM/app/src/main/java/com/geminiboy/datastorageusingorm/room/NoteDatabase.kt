package com.geminiboy.datastorageusingorm.room

import android.content.Context
import androidx.room.*

@Database(entities = [NoteData::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDAO() : NoteDAO
    companion object {

        private var INSTANCE: NoteDatabase? = null

        fun getInstance(context: Context): NoteDatabase? {
            if (INSTANCE == null) {
                synchronized(NoteDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        NoteDatabase::class.java, "Note.db"
                    ).build()
                }
            }
            return INSTANCE
        }
    }

}
