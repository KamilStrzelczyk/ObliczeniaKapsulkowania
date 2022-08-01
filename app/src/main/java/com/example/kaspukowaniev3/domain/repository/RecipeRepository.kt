package com.example.kaspukowaniev3.domain.repository

import com.example.kaspukowaniev3.domain.model.Recipe
import java.net.IDN

interface RecipeRepository {

    fun getRecipe(id: Int) : Recipe
    fun getAll() : List<Recipe>

}