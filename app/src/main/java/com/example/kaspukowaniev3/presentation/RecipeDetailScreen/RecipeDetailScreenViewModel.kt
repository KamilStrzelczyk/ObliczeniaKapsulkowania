package com.example.kaspukowaniev3.presentation.RecipeDetailScreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.kaspukowaniev3.domain.model.Recipe
import com.example.kaspukowaniev3.domain.repository.RecipeRepository
import com.example.kaspukowaniev3.domain.usecase.RecipeDetailScreenUseCase.CalculateAmountOfBoxesUseCase
import com.example.kaspukowaniev3.domain.usecase.RecipeDetailScreenUseCase.CalculateAmountOfSamplesUseCase
import com.example.kaspukowaniev3.domain.usecase.RecipeDetailScreenUseCase.CalculateTheoreticalMassUseCase
import com.example.kaspukowaniev3.domain.usecase.RecipeDetailScreenUseCase.CalculateTimeOfBoxesUseCase
import com.example.kaspukowaniev3.presentation.Utils
import com.example.kaspukowaniev3.presentation.Utils.Companion.COMMA
import com.example.kaspukowaniev3.presentation.Utils.Companion.EMPTY_DOUBLE
import com.example.kaspukowaniev3.presentation.Utils.Companion.EMPTY_INT
import com.example.kaspukowaniev3.presentation.Utils.Companion.EMPTY_STRING
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalTime
import java.util.*
import javax.inject.Inject

@HiltViewModel
class RecipeDetailScreenViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository,
    private val calculateAmountOfSamples: CalculateAmountOfSamplesUseCase,
    private val calculateAmountOfBoxes: CalculateAmountOfBoxesUseCase,
    private val calculateTheoreticalMass: CalculateTheoreticalMassUseCase,
    private val calculateTimeOfBoxes: CalculateTimeOfBoxesUseCase,
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
        val theoreticalMass = calculateTheoreticalMass(
            weightOfPowder,
            recipe.doseWeight,
            recipe.capsulesGross,
        )
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
            theoreticalMass = theoreticalMass
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

    fun onOpenInfoDialogClicked() {
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

    fun onOpenTimeDialogClicked() {
        updateState(state.value.copy(
            showTimeDialog = true,
        ))
    }

    fun onDismissTimeDialogClicked() {
        updateState(state.value.copy(
            showTimeDialog = false,
        ))
    }

    fun onOpenTimePickerDialog() {
        updateState(state.value.copy(
            showTimePickerDialog = true,
        ))
    }

    fun onDismissTimePickerDialog() {
        updateState(state.value.copy(
            showTimePickerDialog = false,
        ))
    }


    fun onTimeChanged(hour: Int, minute: Int) {
        updateState(state.value.copy(
            hour = hour,
            minute = minute,
            showTimePickerDialog = false,
        ))
        onBoxTimeChanged(boxTime = state.value.boxTime)
    }

    fun onBoxTimeChanged(boxTime: String) {
        val listTimeBox = calculateTimeOfBoxes(
            boxTime,
            hour = state.value.hour,
            minute = state.value.minute,
            boxAmount = state.value.boxAmount
        )
        updateState(state.value.copy(
            boxTime = boxTime,
            listTimeBox = listTimeBox
        ))
    }

    fun save() {
        recipeRepository.saveData(
            state.value.amountOfCapsules,
            state.value.boxWeight,
            state.value.weightOfPowder,
            recipe.id)
    }


    private fun updateState(state: ViewModelState) {
        this.state.value = state
    }

    data class ViewModelState(
        val weightOfPowder: String = EMPTY_STRING,
        val amountOfCapsules: String = EMPTY_STRING,
        val boxWeight: String = EMPTY_STRING,
        val boxAmount: String = EMPTY_STRING,
        val boxSample: String = EMPTY_STRING,
        val showInfoDialog: Boolean = false,
        val showTimeDialog: Boolean = false,
        val showTimePickerDialog: Boolean = false,
        val recipeName: String = EMPTY_STRING,
        val doseWeight: Double = EMPTY_DOUBLE,
        val capsulesNet: Double = EMPTY_DOUBLE,
        val capsulesGross: Double = EMPTY_DOUBLE,
        val sample: Int = EMPTY_INT,
        val theoreticalMass: String = EMPTY_STRING,
        val hour: Int = Calendar.HOUR_OF_DAY,
        val minute: Int = Calendar.MINUTE,
        val boxTime: String = EMPTY_STRING,
        val listTimeBox: List<LocalTime> = emptyList(),
    )
}