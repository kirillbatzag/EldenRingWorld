package com.example.eldenringworld.model

data class bossModel(
    val count: Int,
    val `data`: List<bossData>,
    val success: Boolean,
    val total: Int
)