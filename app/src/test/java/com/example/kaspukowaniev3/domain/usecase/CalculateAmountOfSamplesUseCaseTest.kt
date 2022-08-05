package com.example.kaspukowaniev3.domain.usecase

import com.example.kaspukowaniev3.domain.usecase.RecipeDetailScreenUseCase.CalculateAmountOfSamplesUseCase
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class CalculateAmountOfSamplesUseCaseTest {
    private val useCase = CalculateAmountOfSamplesUseCase()
   private val boxAmount = "15"
   private val sample = 340

    @Test
    fun `WHEN user pass correct data THEN result should be calculated and rounded up`(){
        val expectedResult = "23"
        // WHEN
        val result = useCase.invoke(boxAmount, sample,)
        //THEN
        assertEquals(expectedResult, result)
    }

}