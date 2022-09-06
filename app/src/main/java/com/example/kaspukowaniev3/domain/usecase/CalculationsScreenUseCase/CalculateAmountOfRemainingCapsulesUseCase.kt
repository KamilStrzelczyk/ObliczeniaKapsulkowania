package com.example.kaspukowaniev3.domain.usecase.CalculationsScreenUseCase

import com.example.kaspukowaniev3.presentation.Utils
import com.example.kaspukowaniev3.presentation.Utils.Companion.EMPTY_STRING
import javax.inject.Inject

class CalculateAmountOfRemainingCapsulesUseCase @Inject constructor() {

    operator fun invoke(
        wrongCapsules: String,
        amountOfCapsules: String,
        amountOfFillCapsules: String,
    ): String = if (isDataCorrect(
            amountOfFillCapsules,
            wrongCapsules,
        )
    ) {
        (amountOfCapsules.toInt() - amountOfFillCapsules.toInt() - wrongCapsules.toInt()).toString()
    } else {
        EMPTY_STRING
    }

    private fun isDataCorrect(
        amountOfFillCapsules: String,
        wrongCapsules: String,
    ) =
        amountOfFillCapsules.isNotBlank()
                && amountOfFillCapsules.toInt() != 0
                && wrongCapsules.isNotBlank()
                && wrongCapsules.toInt() != 0

}


// ilość pobranych kapsułek - ilość pełnych kapsułek - ilość złych kapsułek