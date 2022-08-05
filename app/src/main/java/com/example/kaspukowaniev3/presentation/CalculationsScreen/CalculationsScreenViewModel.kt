package com.example.kaspukowaniev3.presentation.CalculationsScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.kaspukowaniev3.domain.repository.RecipeRepository
import com.example.kaspukowaniev3.domain.usecase.CalculationsScreenUseCase.CalculateAmountOfFillCapsulesUseCase
import com.example.kaspukowaniev3.domain.usecase.CalculationsScreenUseCase.CalculateAmountOfRemainingCapsulesUseCase
import com.example.kaspukowaniev3.domain.usecase.CalculationsScreenUseCase.CalculateAmountOfWastePowderUseCase
import com.example.kaspukowaniev3.domain.usecase.CalculationsScreenUseCase.CalculateOfEfficiencyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CalculationsScreenViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository,
    private val calculateAmountOfFillCapsules: CalculateAmountOfFillCapsulesUseCase,
    private val calculateAmountOfWastePowder: CalculateAmountOfWastePowderUseCase,
    private val calculateAmountOfRemainingCapsules: CalculateAmountOfRemainingCapsulesUseCase,
    private val calculateOfEfficiency: CalculateOfEfficiencyUseCase,
) : ViewModel() {
    val state = mutableStateOf(ViewModelState())


    init {
        val amountOfCapsules = recipeRepository.getAmount()
        val boxWeight = recipeRepository.getAmount()
        val weightOfPowder = recipeRepository.getAmount()
        state.value = state.value.copy(amountOfCapsules = amountOfCapsules)
        state.value = state.value.copy(boxWeight = boxWeight)
        state.value = state.value.copy(weightOfPowder = weightOfPowder)
    }

    fun onFullBoxesChanged(fullBoxes: String) {
        val amountOfFillCapsules = calculateAmountOfFillCapsules(
            fullBoxes,
            state.value.boxWeight,
            state.value.restOfBoxes,
            state.value.capsulesGross,
        )
        updateState(state.value.copy(
            amountOfFillCapsules = amountOfFillCapsules,
            fullBoxes = fullBoxes,
        ))

    }

    fun onRestBoxesChanged(restOfBoxes: String) {
        val amountOfFillCapsules = calculateAmountOfFillCapsules(
            restOfBoxes,
            state.value.fullBoxes,
            state.value.boxWeight,
            state.value.capsulesGross,
        )
        updateState(state.value.copy(
            amountOfFillCapsules = amountOfFillCapsules,
            restOfBoxes = restOfBoxes,
        ))
    }

    fun onCapsulesGrossChanged(capsulesGross: String) {
        val amountOfFillCapsules = calculateAmountOfFillCapsules(
            capsulesGross,
            state.value.fullBoxes,
            state.value.boxWeight,
            state.value.restOfBoxes,
        )
        updateState(state.value.copy(
            amountOfFillCapsules = amountOfFillCapsules,
            capsulesGross = capsulesGross,
        ))
    }

    fun onCapsulesNettChanged(capsulesNett: String) {
        val wasteOfPowder = calculateAmountOfWastePowder(
            capsulesNett,
            state.value.amountOfFillCapsules,
            state.value.weightOfPowder,
            )
        updateState(state.value.copy(
            wasteOfPowder = wasteOfPowder,
            capsulesNett = capsulesNett,
        ))
    }

    private fun updateState(state: ViewModelState) {
        this.state.value = state
    }

    data class ViewModelState(
        val fullBoxes: String = "",
        val fullBoxesHint: String = "Ilość pełnych wiader",
        val restOfBoxes: String = "",
        val restOfBoxesHint: String = "Ilość z niepełnych wiader",
        val capsulesGross: String = "",
        val capsulesGrossHint: String = "Brutto",
        val capsulesNett: String = "",
        val capsulesNettHint: String = "Netto",
        val wasteOfPowder: String = "",
        val amountOfFillCapsules: String = "",
        val amountOfFillCapsulesHint: String = "Ilość gotowych kaspułek",
        val efficiency: String = "",
        val restOfCapsules: String = "",
        val amountOfCapsules: String = "",
        val boxWeight: String = "",
        val wrongCapsules: String = "",
        val weightOfPowder: String = "",
    )
}