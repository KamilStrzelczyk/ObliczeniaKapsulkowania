package com.example.kaspukowaniev3.domain.usecase.CalculationsScreenUseCase

import javax.inject.Inject

class CalculateAmountOfWastePowderUseCase @Inject constructor() {

    operator fun invoke(
        amountOfFillCapsules: String,
        capsulesNett: String,
        weightOfPowder: String,
    ): String {
        return if (isDataCorrect(
                amountOfFillCapsules,
                capsulesNett,
                weightOfPowder,
            )
        ) {
            ((amountOfFillCapsules.toDouble() * capsulesNett.toDouble()) - weightOfPowder.toDouble()).toString()
        } else {
            ""
        }
    }


    private fun isDataCorrect(
        amountOfFillCapsules: String,
        capsulesNett: String,
        weightOfPowder: String,
    ) =
        amountOfFillCapsules.isNotBlank() && capsulesNett.isNotBlank() && amountOfFillCapsules.toInt() != 0 && capsulesNett.toDouble() != 0.0 && weightOfPowder.isNotBlank() && weightOfPowder.toDouble() != 0.0
}
// ( ilosć pełnych kapsułek * waga kapsułki netto) - ilość porsszku