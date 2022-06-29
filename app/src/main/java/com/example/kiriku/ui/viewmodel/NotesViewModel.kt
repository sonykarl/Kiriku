package com.example.kiriku.ui.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kiriku.database.local.Notes
import com.example.kiriku.database.repository.NotesRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

data class NotesScreenUiState(
    val notes: LiveData<List<Notes>>
)

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val notesRepositoryImpl: NotesRepositoryImpl
): ViewModel() {

    fun addNotes(notes: Notes){
        viewModelScope.launch {
            try {
                notesRepositoryImpl.addNotes(notes = notes)
            }catch (e:IOException){
                Log.e(TAG, "error in getting db")
            }
        }
    }

    val allwords: LiveData<List<Notes>> = notesRepositoryImpl.getNotes()

    val notesscreenuistate = NotesScreenUiState(
        notes = allwords
    )
}