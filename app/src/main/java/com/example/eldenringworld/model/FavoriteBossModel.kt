package com.example.eldenringworld.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class FavoriteBossModel (
    @PrimaryKey val id: Int,
    val description: String,
    val healthPoints: String,
    val image: String,
    val location: String,
    val name: String,
    val region: String
)
