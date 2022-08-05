package com.example.kaspukowaniev3.domain.usecase.CalculationsScreenUseCase

import com.example.kaspukowaniev3.presentation.Utils
import javax.inject.Inject

class CalculateAmountOfRemainingCapsulesUseCase @Inject constructor() {

    operator fun invoke(
        amountOfCapsules: String,
        amountOfFillCapsules: String,
        wrongCapsules: String,
    ): String = if (isDataCorrect(
            amountOfFillCapsules,
            wrongCapsules,
        )
    ) {
        (amountOfCapsules.toInt() - amountOfFillCapsules.toInt() - wrongCapsules.toInt()).toString()
    } else {
        Utils.EMPTY_STRING
    }


    private fun isDataCorrect(
        amountOfFillCapsules: String,
        wrongCapsules: String,
    ) =
        amountOfFillCapsules.isNotBlank() &&
                amountOfFillCapsules.toInt() != 0 &&
                wrongCapsules.isNotBlank() &&
                wrongCapsules.toInt() != 0

}


// ilość pobranych kapsułek - ilość pełnych kapsułek - ilość złych kapsułek