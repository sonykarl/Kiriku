package com.example.kiriku.database.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {

    @Insert
    suspend fun addNote(notes: Notes)

    @Query("SELECT * FROM notes")
    fun getNotes(): LiveData<List<Notes>>
}