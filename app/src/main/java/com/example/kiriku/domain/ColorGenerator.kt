package com.example.kiriku.domain

import com.example.kiriku.database.models.RgbColors


fun colorGenerator(): RgbColors {
    val green = (0..245).random()
    val blue = (0..245).random()
    val red = (0..245).random()
    val rgb = RgbColors(red = red, green = green, blue = blue)
    return rgb
}