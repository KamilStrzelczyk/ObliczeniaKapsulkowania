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
            boxWeight,
        )
    ) {
        ((boxWeight.toInt() * fullBoxes.toInt()) + restOfBoxes.toDouble()).toString()
    } else {
        Utils.EMPTY_STRING
    }

    private fun isDataCorrect(
        fullBoxes: String,
        restOfBoxes: String,
        boxWeight: String,
    ) =
        fullBoxes.isNotBlank()
                && fullBoxes.toInt() != 0
                && restOfBoxes.isNotBlank()
                && restOfBoxes.toDouble() != 0.0
                && boxWeight.isNotBlank()
                && boxWeight.toInt() != 0
}