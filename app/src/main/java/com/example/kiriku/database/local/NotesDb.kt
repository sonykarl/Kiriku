package com.example.kiriku.database.local


import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Notes::class), version = 1, exportSchema = false)
abstract class NotesDb(): RoomDatabase() {
    abstract fun notesDao():NotesDao
}