package com.example.kaspukowaniev3.domain.usecase

import javax.inject.Inject

class CalculateAmountOfFillCapsulesUseCase @Inject constructor() {

    operator fun invoke(
        boxWeight: String,
        fullBoxes: String,
        restOfBoxes: String,
        capsulesGross: String,
    ): String {
        return(((boxWeight.toInt() * fullBoxes.toInt()) + restOfBoxes.toInt()) / capsulesGross.toInt()).toString()

    }
}