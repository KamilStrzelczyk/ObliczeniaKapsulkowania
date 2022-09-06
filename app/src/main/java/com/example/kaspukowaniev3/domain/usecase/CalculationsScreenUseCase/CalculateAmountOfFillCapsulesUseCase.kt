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
            boxWeight,
            fullBoxes,
            restOfBoxes,
            capsulesGross,
        )
    ) {
        (((boxWeight.toInt() * fullBoxes.toInt()) + restOfBoxes.toDouble()) / (capsulesGross.toDouble() / Utils.CHANGE_TO_MILLIGRAM))
            .toInt()
            .toString()
    } else {
        EMPTY_STRING
    }

    private fun isDataCorrect(
        boxWeight: String,
        fullBoxes: String,
        restOfBoxes: String,
        capsulesGross: String,
    ) =
        fullBoxes.isNotBlank()
                && fullBoxes.toInt() != 0
                && restOfBoxes.isNotBlank()
                && restOfBoxes.toDouble() != 0.0
                && capsulesGross.isNotBlank()
                && capsulesGross.toDouble() != 0.0
                && boxWeight.isNotBlank()
                && boxWeight.toInt() != 0
}