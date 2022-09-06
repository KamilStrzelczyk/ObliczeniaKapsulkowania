package com.example.kaspukowaniev3.domain.repository

import com.example.kaspukowaniev3.domain.model.Recipe

interface RecipeRepository {

    suspend fun getRecipe(id: Int): Recipe
    suspend fun getAll(): List<Recipe>
    fun saveData(
        amountOfCapsules: String,
        boxWeight: String,
        weightOfPowder: String,
        activeRecipeId: Int,
    ): Unit

    fun getAmount(): String
    fun getBoxWeight(): String
    fun getWeightOfPowder(): String
    fun getActiveRecipeId(): Int
}