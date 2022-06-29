package com.example.kiriku.database.repository

import androidx.lifecycle.LiveData
import com.example.kiriku.database.local.Notes
import kotlinx.coroutines.flow.Flow

interface NotesRepository {
    suspend fun addNotes(notes: Notes)
    fun getNotes(): LiveData<List<Notes>>
}