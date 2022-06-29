package com.example.kiriku.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.kiriku.database.local.Notes
import com.example.kiriku.ui.viewmodel.NotesScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun notesScreen(notesScreenUiState: NotesScreenUiState, lifecycleOwner: LifecycleOwner){

    val notesArray: MutableState<List<Notes>?> = remember {
        mutableStateOf(null)
    }

    notesScreenUiState.notes.observe(lifecycleOwner, Observer{
        notesArray.value = it
    })

    LazyColumn(){
        notesArray.value?.let {
            items(it.toList()){
                Card() {
                    Text(text = "${it.title}")
                    Text(text = "${it.body}")
                }
            }
        }
    }
}