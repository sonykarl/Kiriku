package com.example.kiriku.database.repository

import androidx.lifecycle.LiveData
import com.example.kiriku.database.local.Notes
import com.example.kiriku.database.local.NotesDao
import com.example.kiriku.database.local.NotesDb
import kotlinx.coroutines.flow.Flow

class NotesRepositoryImpl(
    private val notesDao: NotesDao
): NotesRepository {

    override suspend fun addNotes(notes: Notes) {
        return notesDao.addNote(notes = notes)
    }

    override fun getNotes(): LiveData<List<Notes>> {
        return  notesDao.getNotes()
    }
}