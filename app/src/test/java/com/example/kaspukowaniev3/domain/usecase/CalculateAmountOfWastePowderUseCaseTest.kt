package com.example.kaspukowaniev3.domain.usecase

import com.example.kaspukowaniev3.domain.usecase.CalculationsScreenUseCase.CalculateAmountOfWastePowderUseCase
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class CalculateAmountOfWastePowderUseCaseTest {

    private val useCase = CalculateAmountOfWastePowderUseCase()
    private val amountOfFillCapsules = "991568"
    private val capsulesNett = "2205"
    private val weightOfPowder = "221.5"
    private val expectedResult = ""

    @Test
    fun `WHEN user pass correct data THEN result should be calculated and rounded up to third places`() {
        val expectedResult = "2.859"
        // WHEN
        val result = useCase.invoke(amountOfFillCapsules, capsulesNett, weightOfPowder)
        //THEN
        assertEquals(expectedResult, result)
    }
}