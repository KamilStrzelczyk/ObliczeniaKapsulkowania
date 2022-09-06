package com.example.kaspukowaniev3.infostructure.database.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kaspukowaniev3.domain.model.Recipe
import com.example.kaspukowaniev3.infostructure.database.entities.RecipeEntity
import javax.inject.Inject

@Dao
interface RecipeDAO {
    @Query("SELECT * FROM recipe_table")
    suspend fun getAllRecipes(): List<RecipeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg recipe: RecipeEntity)

    @Query("SELECT * FROM recipe_table WHERE id = :recipeId")
    suspend fun getRecipe(recipeId: Int): RecipeEntity

}