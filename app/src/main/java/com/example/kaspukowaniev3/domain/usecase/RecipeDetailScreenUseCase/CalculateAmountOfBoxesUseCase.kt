package com.example.kaspukowaniev3.domain.usecase.RecipeDetailScreenUseCase

import com.example.kaspukowaniev3.presentation.Utils
import com.example.kaspukowaniev3.presentation.Utils.Companion.EMPTY_STRING
import java.math.RoundingMode
import javax.inject.Inject

class CalculateAmountOfBoxesUseCase @Inject constructor() {

    operator fun invoke(
        boxWeight: String,
        weightOfPowder: String,
        doseWeight: Double,
        capsulesGross: Double,
    ): String = if (isDataCorrect(boxWeight, weightOfPowder)) {
        val amountOfFullCapsules = (weightOfPowder.toDouble() / doseWeight) * capsulesGross
        (amountOfFullCapsules / boxWeight.toDouble())
            .toBigDecimal()
            .setScale(0, RoundingMode.UP)
            .toString()
    } else {
        EMPTY_STRING
    }

    private fun isDataCorrect(
        boxWeight: String,
        weightOfPowder: String,
    ) =
        weightOfPowder.isNotBlank() &&
                boxWeight.isNotBlank() &&
                weightOfPowder.toDouble() != 0.0 &&
                boxWeight.toDouble() != 0.0
}