package com.example.kaspukowaniev3.domain.usecase

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class CalculateAmountOfBoxesUseCaseTest {

    private val useCase = CalculateAmountOfBoxesUseCase()

    private val boxWeight = "18"
    private val weight = "200"
    private val doseWeight = 0.000215
    private val capsulesGross = 0.000295
    private val expectedResult = ""

    // testy na pustego stringa x2
    @Test
    fun `WHEN user pass correct data THEN result should be calculated and rounded up`() {
        val expectedResult = "16"
        // WHEN
        val result = useCase.invoke(boxWeight, weight, doseWeight, capsulesGross)
        //THEN
        assertEquals(expectedResult, result)
    }

    @Test
    fun `WHEN boxWeight equal 0 THEN result should be empty`() {
        //GIVEN
        val boxWeight = "0"
        //WHEN
        val result = useCase.invoke(boxWeight, weight, doseWeight, capsulesGross)
        //THEN
        assertEquals(expectedResult, result)
    }

    @Test
    fun `WHEN weight equal 0 THEN result should be empty`() {
        //GIVEN
        val weight = "0"
        //WHEN
        val result = useCase.invoke(boxWeight, weight, doseWeight, capsulesGross)
        //THEN
        assertEquals(expectedResult, result)
    }

}