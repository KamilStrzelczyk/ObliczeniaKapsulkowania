package com.example.kaspukowaniev3.presentation

sealed class Screen(val route: String) {
    object RecipeScreen : Screen("RecipeScreen")
    object RecipeDetailScreen : Screen("RecipeDetailScreen")
    object CalculationsScreen : Screen ("CalculationsScreen")
}


