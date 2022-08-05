package com.example.kaspukowaniev3.domain.usecase.CalculationsScreenUseCase

import javax.inject.Inject

class CalculateAmountOfFillCapsulesUseCase @Inject constructor() {

    operator fun invoke(
        boxWeight: String,
        fullBoxes: String,
        restOfBoxes: String,
        capsulesGross: String,
    ): String {
        return if (isDataCorrect(
                boxWeight,
                fullBoxes,
                restOfBoxes,
                capsulesGross,
            )
        ) {
            (((boxWeight.toInt() * fullBoxes.toInt()) + restOfBoxes.toDouble()) / capsulesGross.toDouble()).toString()
        } else {
            ""
        }


    }

    private fun isDataCorrect(
        boxWeight: String,
        fullBoxes: String,
        restOfBoxes: String,
        capsulesGross: String,
    ) =
        boxWeight.isNotBlank() && fullBoxes.isNotBlank() && restOfBoxes.isNotBlank() && capsulesGross.isNotBlank() && boxWeight.toInt() != 0 && fullBoxes.toInt() != 0 && restOfBoxes.toDouble() != 0.0 && capsulesGross.toDouble() != 0.0
}