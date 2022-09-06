package com.example.kaspukowaniev3.domain.usecase

import com.example.kaspukowaniev3.domain.repository.RecipeRepository
import javax.inject.Inject

class GetAllRecipesUseCase @Inject constructor(private val recipeRepository: RecipeRepository) {
    operator fun invoke() =
        recipeRepository.getAll()

}