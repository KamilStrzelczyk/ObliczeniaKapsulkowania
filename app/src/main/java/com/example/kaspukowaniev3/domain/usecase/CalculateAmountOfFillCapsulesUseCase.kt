package com.example.kaspukowaniev3.domain.usecase

import javax.inject.Inject

class CalculateAmountOfFillCapsulesUseCase @Inject constructor() {

    operator fun invoke(
        boxWeight: String,
        fullBoxes: String,
        restOfBoxes: String,
        capsulesGross: String,
    ): String {
        if (isDataCorrect(
                boxWeight,
                fullBoxes,
                restOfBoxes,
                capsulesGross,
            )
        ) {
            return (((boxWeight.toInt() * fullBoxes.toInt()) + restOfBoxes.toInt()) / capsulesGross.toInt()).toString()
        } else {
            return ""
        }


    }

    private fun isDataCorrect(
        boxWeight: String,
        fullBoxes: String,
        restOfBoxes: String,
        capsulesGross: String,
    ) =
        boxWeight.isNotBlank() && fullBoxes.isNotBlank() && restOfBoxes.isNotBlank() && capsulesGross.isNotBlank() && boxWeight.toInt() != 0 && fullBoxes.toInt() != 0 && restOfBoxes.toInt() != 0 && capsulesGross.toInt() != 0
}