package com.example.kaspukowaniev3.domain.usecase.CalculationsScreenUseCase

import com.example.kaspukowaniev3.presentation.Utils.Companion.EMPTY_STRING
import com.example.kaspukowaniev3.presentation.Utils.Companion.VALUE_FOR_EFFICIENCY
import javax.inject.Inject

class CalculateOfEfficiencyUseCase @Inject constructor() {

    operator fun invoke(
        weightOfFinishedProducts: String,
        weightOfPowder: String,
    ): String = if (isDataCorrect(
            weightOfFinishedProducts,
            weightOfPowder,
        )
    ) {
        ((VALUE_FOR_EFFICIENCY * weightOfFinishedProducts.toDouble()) / weightOfPowder.toDouble()).toString()
    } else {
        EMPTY_STRING
    }

    private fun isDataCorrect(
        weightOfFinishedProducts: String,
        weightOfPowder: String,
    ) =
        weightOfFinishedProducts.isNotBlank() &&
                weightOfFinishedProducts.toDouble() != 0.0 &&
                weightOfPowder.isNotBlank() &&
                weightOfPowder.toDouble() != 0.0
}

// 74,37% x masa kapsułek / masa pobranego porszku =