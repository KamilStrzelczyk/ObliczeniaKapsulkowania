package com.example.kaspukowaniev3.domain.usecase.RecipeDetailScreenUseCase

import com.example.kaspukowaniev3.presentation.Utils
import javax.inject.Inject

class CalculateTheoreticalMassUseCase @Inject constructor() {
    operator fun invoke(
        weightOfPowder: String,
        doseWeight: Double,
        capsulesGross: Double,
    ): String = if (isDataCorrect(
            weightOfPowder,
        )
    ) {
        ((weightOfPowder.toDouble() / doseWeight) * capsulesGross).toInt().toString()
    } else {
        Utils.EMPTY_STRING
    }

    private fun isDataCorrect(
        weightOfPowder: String,
    ) = weightOfPowder.isNotBlank() && weightOfPowder.toDouble() != 0.0
}