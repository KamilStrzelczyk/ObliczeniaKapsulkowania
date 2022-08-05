package com.example.kaspukowaniev3.domain.usecase.CalculationsScreenUseCase

import com.example.kaspukowaniev3.presentation.Utils.Companion.EMPTY_STRING
import com.example.kaspukowaniev3.presentation.Utils.Companion.VALUE_FOR_EFFICIENCY
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
        ((VALUE_FOR_EFFICIENCY * amountOfFillCapsules.toInt()) / weightOfPowder.toDouble()).toString()
    } else {
        EMPTY_STRING
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