package com.example.kiriku.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.kiriku.database.local.Notes
import com.example.kiriku.database.models.RgbColors

@Composable
fun notesCard(rgbColors: RgbColors, notes: List<Notes>){
    Card(
        shape = RoundedCornerShape(6.dp),
        backgroundColor = Color(rgbColors.red,rgbColors.green,rgbColors.blue),
    ) {
        Column(
            modifier = Modifier.padding(9.dp)
        ) {
            LazyColumn(){
                items(items = notes){
                    Text(text = "${it.title}")
                    Text(text = "${it.body}")
                }
            }
        }
    }
}