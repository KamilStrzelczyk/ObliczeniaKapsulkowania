package com.example.kaspukowaniev3.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import com.example.kaspukowaniev3.domain.model.Recipe
import com.example.kaspukowaniev3.domain.repository.RecipeRepository
import com.example.kaspukowaniev3.domain.usecase.CalculateAmountOfBoxesUseCase
import com.example.kaspukowaniev3.domain.usecase.CalculateAmountOfSamplesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeDetailScreenViewModel @Inject constructor(
    private val getAllRecipeRepository: RecipeRepository,
    private val calculateAmountOfSamples: CalculateAmountOfSamplesUseCase,
    private val calculateAmountOfBoxes: CalculateAmountOfBoxesUseCase,
) : ViewModel() {

    val state = mutableStateOf(ViewModelState())
    private lateinit var recipe: Recipe

    fun initData(id: Int) {
        val newRecipe = getAllRecipeRepository.getRecipe(id)
//        if (this::recipe.isInitialized && newRecipe.id != recipe.id) {
//            updateState(ViewModelState()
//            )
//        }
        recipe = newRecipe
    }

    fun onWeightChanged(weight: String) {
        val boxAmount = calculateAmountOfBoxes(
            weight,
            state.value.boxWeight,
            recipe.doseWeight,
            recipe.capsulesGross)
        val sample = calculateAmountOfSamples(state.value.boxAmount, recipe.sample)
        updateState(state.value.copy(
            boxAmount = boxAmount,
            boxSample = sample,
            weight = weight,
        ))
    }

    fun onBoxWeightChanged(boxWeight: String) {
        val boxAmount = calculateAmountOfBoxes(
            boxWeight,
            state.value.weight,
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

    private fun updateState(state: ViewModelState) {
        this.state.value = state
    }

    data class ViewModelState(
        val weight: String = "",
        val amountOfCapsules: String = "",
        val boxWeight: String = "",
        val weightHint: String = "Masa pobranego proszku",
        val amountOfCapsulesHint: String = "Pobrana ilość kapsułek",
        val boxHint: String = "Ilość kapsułek w pojemniku w kg",
        val boxAmountValue: String = "Ilość pojemników",
        val boxAmount: String = "",
        val amountSampleValue: String = "Ilość prób",
        val boxSample: String = "",
        val buttonHint: String = "ROZLICZENIE",
        val showInfoDialog: Boolean = false,
        val recipeName: String = "",
        val doseWeight: Double = 0.0,
        val capsulesNet: Double = 0.0,
        val capsulesGross: Double = 0.0,
        val sample: Int = 0,
    )
}