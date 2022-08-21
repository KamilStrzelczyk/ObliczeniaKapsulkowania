package com.example.kaspukowaniev3.domain.repository

import com.example.kaspukowaniev3.domain.model.Recipe

interface RecipeRepository {

    fun getRecipe(id: Int): Recipe
    fun getAll(): List<Recipe>
    fun saveData(amountOfCapsules: String, boxWeight: String, weightOfPowder: String): Unit
    fun getAmount(): String
    fun getBoxWeight(): String
    fun weightOfPowder(): String
}