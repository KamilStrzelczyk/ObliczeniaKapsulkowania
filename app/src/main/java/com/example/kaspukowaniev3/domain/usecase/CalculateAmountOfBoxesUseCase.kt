package com.example.kaspukowaniev3.domain.usecase

import java.math.RoundingMode
import javax.inject.Inject

class CalculateAmountOfBoxesUseCase @Inject constructor() {

    operator fun invoke(
        boxWeight: String,
        weight: String,
        doseWeight: Double,
        capsulesGross: Double,
    ): String {
        if (isDataCorrect(boxWeight, weight)) {
            val amountOfFullCapsules = (weight.toInt() / doseWeight) * capsulesGross
            return (amountOfFullCapsules / boxWeight.toInt())
                .toBigDecimal()
                .setScale(0, RoundingMode.UP)
                .toString()
        } else {
            return ""
        }


    }

    private fun isDataCorrect(
        boxWeight: String,
        weight: String,
    ) = weight.isNotBlank() && boxWeight.isNotBlank() && weight.toInt() != 0 && boxWeight.toInt() != 0


}