package com.example.kaspukowaniev3.domain.usecase

import com.example.kaspukowaniev3.domain.usecase.CalculationsScreenUseCase.CalculateAmountOfFillCapsulesUseCase
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class CalculateAmountOfFillCapsulesUseCaseTest {

    private val useCase = CalculateAmountOfFillCapsulesUseCase()

    private val boxWeight = "17"
    private val fullBoxes = "17"
    private val restOfBoxes = "5"
    private val capsulesGross = "2965"
    private val expectedResult = ""

    @Test
    fun `WHEN user pass correct data THEN result should be calculated and rounded up`() {
        val expectedResult = "991568"
        // WHEN
        val result = useCase.invoke(boxWeight, fullBoxes, restOfBoxes, capsulesGross)
        //THEN
        assertEquals(expectedResult, result)
    }
}