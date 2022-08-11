package com.example.kaspukowaniev3.domain.usecase.CalculationsScreenUseCase

import com.example.kaspukowaniev3.presentation.Utils
import javax.inject.Inject

class CalculateWeightOfFinishedProductsUseCase @Inject constructor() {
    operator fun invoke(
        boxWeight: String,
        fullBoxes: String,
        restOfBoxes: String,
    ): String = if (isDataCorrect(
            fullBoxes,
            restOfBoxes,
        ) ) {
        ((boxWeight.toInt() * fullBoxes.toInt()) + restOfBoxes.toDouble()).toString()
    } else {
        Utils.EMPTY_STRING
    }
    private fun isDataCorrect(
        fullBoxes: String,
        restOfBoxes: String,
    ) =
        fullBoxes.isNotBlank() &&
                restOfBoxes.isNotBlank() &&
                fullBoxes.toInt() != 0 &&
                restOfBoxes.toDouble() != 0.0
}