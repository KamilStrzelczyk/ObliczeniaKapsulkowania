package com.example.kaspukowaniev3.infostructure.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kaspukowaniev3.infostructure.database.DAO.RecipeDAO
import com.example.kaspukowaniev3.infostructure.database.entities.RecipeEntity
import com.example.kaspukowaniev3.infostructure.database.DAO.SeriesDAO
import com.example.kaspukowaniev3.infostructure.database.entities.SeriesEntity

@Database(
    entities = [
        RecipeEntity::class,
        SeriesEntity::class,
    ],
    version = 1,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getRecipeDAO(): RecipeDAO
    abstract fun getSeriesDAO(): SeriesDAO
}
