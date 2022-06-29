package com.example.kiriku.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.example.kiriku.database.local.Notes
import com.example.kiriku.ui.viewmodel.NotesViewModel

@Composable
fun addNotesScreen(viewModel: NotesViewModel, navController: NavController){
    val title  = remember{ mutableStateOf("")}
    val body  = remember{ mutableStateOf("")}
    Column() {
        TextField(value = title.value, onValueChange = {
            title.value = it
        })

        TextField(value = body.value, onValueChange = {
            body.value = it
        })

        Button(onClick = {
            viewModel.addNotes(notes = Notes(
                title = title.value,
                body = body.value
            ))
        }) {
            Text(text = "ADD NOTE")
        }

        Button(onClick = {
            navController.navigate("noteslist")
        }) {
            Text(text = "BACK")
        }
    }



}