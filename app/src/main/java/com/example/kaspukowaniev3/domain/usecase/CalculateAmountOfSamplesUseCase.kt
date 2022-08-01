package com.example.kaspukowaniev3.domain.usecase

import java.math.RoundingMode
import javax.inject.Inject


class CalculateAmountOfSamplesUseCase @Inject constructor() {

    operator fun invoke(boxAmount: String, sample: Int) =
        boxAmount
            .takeIf { it.isNotBlank() }
            ?.run {
                return (sample / this.toDouble())
                    .toBigDecimal()
                    .setScale(0, RoundingMode.UP)
                    .toString()
            } ?: ""
}