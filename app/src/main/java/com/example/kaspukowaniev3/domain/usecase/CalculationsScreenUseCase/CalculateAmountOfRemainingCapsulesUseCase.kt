package com.example.kaspukowaniev3.domain.usecase.CalculationsScreenUseCase

import javax.inject.Inject

class CalculateAmountOfRemainingCapsulesUseCase @Inject constructor() {

    operator fun invoke(
        amountOfCapsules: String,
        amountOfFillCapsules: String,
        wrongCapsules: String,
    ): String {
        return if (isDataCorrect(
                amountOfCapsules,
                amountOfFillCapsules,
                wrongCapsules,
            )
        ) {
            (amountOfCapsules.toInt() - amountOfFillCapsules.toInt() - wrongCapsules.toInt()).toString()
        } else {
            return ""
        }

    }

    private fun isDataCorrect(
        amountOfCapsules: String,
        amountOfFillCapsules: String,
        wrongCapsules: String,
    ) =
        amountOfFillCapsules.isNotBlank() && amountOfCapsules.isNotBlank() && amountOfFillCapsules.toInt() != 0 && amountOfCapsules.toDouble() != 0.0 && wrongCapsules.isNotBlank() && wrongCapsules.toInt() != 0

}


// ilość pobranych kapsułek - ilość pełnych kapsułek - ilość złych kapsułek