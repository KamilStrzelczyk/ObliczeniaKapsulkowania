package com.example.kaspukowaniev3.domain.usecase.RecipeDetailScreenUseCase

import com.example.kaspukowaniev3.presentation.Utils
import com.example.kaspukowaniev3.presentation.Utils.Companion.EMPTY_STRING
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
            } ?: EMPTY_STRING
}