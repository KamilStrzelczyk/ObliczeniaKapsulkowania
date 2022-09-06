package com.example.kaspukowaniev3.presentation.RecipeTypesScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.kaspukowaniev3.domain.usecase.GetAllRecipesUseCase
import com.example.kaspukowaniev3.presentation.RecipeRowData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeTypesViewModel @Inject constructor(private val getAllRecipes: GetAllRecipesUseCase) :
    ViewModel() {
    public fun loadData() = getAllRecipes()
        .map { recipe ->
            RecipeRowData(recipe.id, recipe.recipeName)
        }
}

