package com.example.kaspukowaniev3.domain.usecase.CalculationsScreenUseCase

import com.example.kaspukowaniev3.domain.repository.RecipeRepository
import com.example.kaspukowaniev3.presentation.Utils.Companion.EMPTY_STRING
import java.math.RoundingMode

import javax.inject.Inject

class CalculateOfEfficiencyUseCase @Inject constructor(
    private val recipeRepository: RecipeRepository,
) {
    suspend operator fun invoke(
        wrongCapsulesFromStartUp: String,
        weightOfFinishedProducts: String,
        weightOfPowder: String,
    ): String = if (isDataCorrect(
            wrongCapsulesFromStartUp,
            weightOfFinishedProducts,
            weightOfPowder,
        )
    ) {
        val valueForEfficiency =
            recipeRepository.getRecipe(recipeRepository.getActiveRecipeId()).valueForEfficiency
        ((valueForEfficiency * (weightOfFinishedProducts.toDouble() + wrongCapsulesFromStartUp.toDouble())) / weightOfPowder.toDouble())
            .toBigDecimal()
            .setScale(1, RoundingMode.HALF_UP)
            .toString()
    } else {
        EMPTY_STRING
    }

    private fun isDataCorrect(
        weightOfFinishedProducts: String,
        weightOfPowder: String,
        wrongCapsulesFromStartUp: String,
    ) =
        weightOfFinishedProducts.isNotBlank()
                && weightOfFinishedProducts.toDouble() != 0.0
                && weightOfPowder.isNotBlank()
                && weightOfPowder.toDouble() != 0.0
                && wrongCapsulesFromStartUp.isNotBlank()
                && wrongCapsulesFromStartUp.toDouble() != 0.0
}

// 74,37% x masa kapsułek / masa pobranego porszku =