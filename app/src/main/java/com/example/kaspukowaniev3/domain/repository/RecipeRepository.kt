package com.example.kaspukowaniev3.domain.repository

import com.example.kaspukowaniev3.domain.model.Recipe

interface RecipeRepository {

    fun getAll() : List<Recipe>

}