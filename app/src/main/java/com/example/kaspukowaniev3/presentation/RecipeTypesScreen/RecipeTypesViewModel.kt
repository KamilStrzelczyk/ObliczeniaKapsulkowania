package com.example.kaspukowaniev3.presentation.RecipeTypesScreen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kaspukowaniev3.domain.usecase.GetAllRecipesUseCase
import com.example.kaspukowaniev3.presentation.RecipeRowData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeTypesViewModel @Inject constructor(private val getAllRecipes: GetAllRecipesUseCase) :
    ViewModel() {
    val state = mutableStateOf(ViewModelState())

    init {
        viewModelScope.launch {
            state.value = state.value.copy(
                recipes =
                getAllRecipes()
                    .map { recipe ->
                        RecipeRowData(recipe.id, recipe.recipeName)
                    })
        }
    }

    data class ViewModelState(
        val recipes: List<RecipeRowData> = emptyList(),
    )
}

