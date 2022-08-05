package com.example.kaspukowaniev3.domain.repository

import androidx.compose.ui.text.font.FontWeight
import com.example.kaspukowaniev3.domain.model.Recipe
import java.net.IDN

interface RecipeRepository {

    fun getRecipe(id: Int) : Recipe
    fun getAll() : List<Recipe>
    fun saveData(amountOfCapsules: String, boxWeight: String, weightOfPowder: String ): Unit
    fun getAmount(): String

}