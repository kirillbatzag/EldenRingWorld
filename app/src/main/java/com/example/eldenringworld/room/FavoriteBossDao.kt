package com.example.eldenringworld.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.eldenringworld.model.FavoriteBossModel

@Dao
interface FavoriteBossDao {
    @Insert
    suspend fun insert(favoriteBossDao: FavoriteBossModel)

    @Query("SELECT * FROM favoritebossmodel")
    suspend fun getAllFavoriteBosses():List<FavoriteBossModel>

    @Delete
    suspend fun delete(favoriteBossDao: FavoriteBossModel)
}