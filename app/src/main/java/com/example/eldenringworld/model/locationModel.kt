package com.example.eldenringworld.model

data class locationModel(
    val count: Int,
    val `data`: List<locationData>,
    val success: Boolean,
    val total: Int
)