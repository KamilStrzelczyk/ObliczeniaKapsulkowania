package com.example.kaspukowaniev3.infostructure.database.DAO

import androidx.room.Dao
import androidx.room.Query
import com.example.kaspukowaniev3.infostructure.database.entities.RecipeEntity
import com.example.kaspukowaniev3.infostructure.database.entities.SeriesEntity

@Dao
interface SeriesDAO {
    @Query("SELECT * FROM series_table")
    suspend fun getAllSeries(): List<SeriesEntity>


}