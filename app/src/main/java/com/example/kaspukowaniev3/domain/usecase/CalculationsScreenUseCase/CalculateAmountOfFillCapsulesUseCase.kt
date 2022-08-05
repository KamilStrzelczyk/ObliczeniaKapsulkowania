package com.example.kaspukowaniev3.domain.usecase.CalculationsScreenUseCase

import com.example.kaspukowaniev3.presentation.Utils
import com.example.kaspukowaniev3.presentation.Utils.Companion.EMPTY_STRING
import javax.inject.Inject

class CalculateAmountOfFillCapsulesUseCase @Inject constructor() {

    operator fun invoke(
        boxWeight: String,
        fullBoxes: String,
        restOfBoxes: String,
        capsulesGross: String,
    ): String = if (isDataCorrect(
            fullBoxes,
            restOfBoxes,
            capsulesGross,
        )
    ) {
        (((boxWeight.toInt() * fullBoxes.toInt()) + restOfBoxes.toDouble()) / capsulesGross.toDouble()).toString()
    } else {
        EMPTY_STRING
    }

    private fun isDataCorrect(
        fullBoxes: String,
        restOfBoxes: String,
        capsulesGross: String,
    ) =
        fullBoxes.isNotBlank() &&
                restOfBoxes.isNotBlank() &&
                capsulesGross.isNotBlank() &&
                fullBoxes.toInt() != 0 &&
                restOfBoxes.toDouble() != 0.0 &&
                capsulesGross.toDouble() != 0.0
}