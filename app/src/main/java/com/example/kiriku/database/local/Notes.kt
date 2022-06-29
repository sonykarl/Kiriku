package com.example.kiriku.database.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kiriku.database.models.RgbColors

@Entity(tableName = "Notes")
data class Notes(
    @PrimaryKey(autoGenerate = true)
    val id:Int? = null,
    @ColumnInfo(name = "title")
    val title:String,
    @ColumnInfo(name = "body")
    val body:String,
    @ColumnInfo(name = "color")
    val colors: RgbColors
)

