package com.example.kaspukowaniev3.presentation.RecipeDetailScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.kaspukowaniev3.domain.model.Recipe
import com.example.kaspukowaniev3.domain.repository.RecipeRepository
import com.example.kaspukowaniev3.domain.usecase.RecipeDetailScreenUseCase.CalculateAmountOfBoxesUseCase
import com.example.kaspukowaniev3.domain.usecase.RecipeDetailScreenUseCase.CalculateAmountOfSamplesUseCase
import com.example.kaspukowaniev3.presentation.Utils
import com.example.kaspukowaniev3.presentation.Utils.Companion.COMMA
import com.example.kaspukowaniev3.presentation.Utils.Companion.EMPTY_STRING
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeDetailScreenViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository,
    private val calculateAmountOfSamples: CalculateAmountOfSamplesUseCase,
    private val calculateAmountOfBoxes: CalculateAmountOfBoxesUseCase,
) : ViewModel() {

    val state = mutableStateOf(ViewModelState())
    private lateinit var recipe: Recipe

    fun initData(id: Int) {
        val newRecipe = recipeRepository.getRecipe(id)
//        if (this::recipe.isInitialized && newRecipe.id != recipe.id) {
//            updateState(ViewModelState()
//            )
//        }
        recipe = newRecipe
    }

    fun onWeightChanged(weightOfPowder: String) {
        val newValueWeight = weightOfPowder.replace(COMMA, Utils.DOT)
        val boxAmount = calculateAmountOfBoxes(
            newValueWeight,
            state.value.boxWeight,
            recipe.doseWeight,
            recipe.capsulesGross)
        val sample = calculateAmountOfSamples(state.value.boxAmount, recipe.sample)
        updateState(state.value.copy(
            boxAmount = boxAmount,
            boxSample = sample,
            weightOfPowder = weightOfPowder,
        ))
    }

    fun onBoxWeightChanged(boxWeight: String) {
        val newBoxWeight = boxWeight.replace(COMMA, Utils.DOT)
        val boxAmount = calculateAmountOfBoxes(
            newBoxWeight,
            state.value.weightOfPowder,
            recipe.doseWeight,
            recipe.capsulesGross)
        val samples = calculateAmountOfSamples(boxAmount, recipe.sample)
        updateState(state.value.copy(
            boxWeight = boxWeight,
            boxAmount = boxAmount,
            boxSample = samples,
        ))
    }

    fun onAmountChanged(amount: String) {
        updateState(state.value.copy(
            amountOfCapsules = amount
        ))
    }

    fun onOpenDialogClicked() {
        updateState(state.value.copy(
            showInfoDialog = true,
            recipeName = recipe.recipeName,
            doseWeight = recipe.doseWeight,
            capsulesNet = recipe.capsulesNet,
            capsulesGross = recipe.capsulesGross,
            sample = recipe.sample,
        ))
    }

    fun onDismissOpenDialog() {
        updateState(state.value.copy(
            showInfoDialog = false
        ))
    }

    fun save() {
        recipeRepository.saveData(state.value.amountOfCapsules,
            state.value.boxWeight,
            state.value.weightOfPowder)
    }

    private fun updateState(state: ViewModelState) {
        this.state.value = state
    }

    data class ViewModelState(
        val weightOfPowder: String = EMPTY_STRING,
        val amountOfCapsules: String = EMPTY_STRING,
        val boxWeight: String = EMPTY_STRING,
        val weightHint: String = "Masa pobranego proszku",
        val amountOfCapsulesHint: String = "Pobrana ilość kapsułek",
        val boxHint: String = "Ilość kapsułek w pojemniku w kg",
        val boxAmountValue: String = "Ilość pojemników",
        val boxAmount: String = EMPTY_STRING,
        val amountSampleValue: String = "Ilość prób",
        val boxSample: String = EMPTY_STRING,
        val buttonHint: String = "ROZLICZENIE",
        val showInfoDialog: Boolean = false,
        val recipeName: String = EMPTY_STRING,
        val doseWeight: Double = 0.0,
        val capsulesNet: Double = 0.0,
        val capsulesGross: Double = 0.0,
        val sample: Int = 0,
    )
}