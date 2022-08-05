package com.example.kaspukowaniev3.domain.usecase.CalculationsScreenUseCase

import com.example.kaspukowaniev3.presentation.Utils
import javax.inject.Inject

class CalculateOfEfficiencyUseCase @Inject constructor() {

    operator fun invoke(
        amountOfFillCapsules: String,
        weightOfPowder: String,
    ): String = if (isDataCorrect(
            amountOfFillCapsules,
            weightOfPowder,
        )
    ) {
        ((74.37 * amountOfFillCapsules.toInt()) / weightOfPowder.toDouble()).toString()
    } else {
        Utils.EMPTY_STRING
    }

    private fun isDataCorrect(
        amountOfFillCapsules: String,
        weightOfPowder: String,
    ) =
        amountOfFillCapsules.isNotBlank() &&
                amountOfFillCapsules.toInt() != 0 &&
                weightOfPowder.isNotBlank() &&
                weightOfPowder.toDouble() != 0.0
}

// 74,37% x masa kapsułek / masa pobranego porszku =