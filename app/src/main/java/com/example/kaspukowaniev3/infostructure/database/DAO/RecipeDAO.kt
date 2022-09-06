package com.example.kaspukowaniev3.infostructure.database.DAO

import androidx.room.Dao
import androidx.room.Query
import com.example.kaspukowaniev3.infostructure.database.entities.RecipeEntity

@Dao
interface RecipeDAO {
    @Query("SELECT * FROM recipe_table")
    fun getAll(): List<RecipeEntity>
}