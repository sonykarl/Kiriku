package com.example.kiriku.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import com.example.kiriku.database.local.Notes
import com.example.kiriku.domain.colorGenerator
import com.example.kiriku.ui.components.notesCard
import com.example.kiriku.ui.viewmodel.NotesScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun notesScreen(notesScreenUiState: NotesScreenUiState, lifecycleOwner: LifecycleOwner, navController: NavController){

    val notesArray: MutableState<List<Notes>?> = remember {
        mutableStateOf(null)
    }

    notesScreenUiState.notes.observe(lifecycleOwner, Observer{
        notesArray.value = it
    })

    Column(
        modifier = Modifier.padding(7.dp)
    ) {
        Button(onClick = {
            navController.navigate("addnotes")
        }) {
            Text(text = "ADD NOTE")
        }

        notesArray.value?.let { notesCard(rgbColors = colorGenerator(), notes = it) }
    }

}