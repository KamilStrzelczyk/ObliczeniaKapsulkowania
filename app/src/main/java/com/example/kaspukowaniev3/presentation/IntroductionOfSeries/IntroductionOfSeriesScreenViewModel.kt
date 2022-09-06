package com.example.kaspukowaniev3.presentation.IntroductionOfSeries

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.kaspukowaniev3.domain.model.Recipe
import com.example.kaspukowaniev3.domain.model.Seria
import com.example.kaspukowaniev3.domain.repository.RecipeRepository
import com.example.kaspukowaniev3.domain.repository.SeriesRepository
import com.example.kaspukowaniev3.domain.usecase.IntroductionOfSeriesScreen.SaveNewSeriesUseCase
import com.example.kaspukowaniev3.domain.usecase.LoadSeriesUseCase
import com.example.kaspukowaniev3.presentation.Utils
import com.example.kaspukowaniev3.presentation.Utils.Companion.EMPTY_INT
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class IntroductionOfSeriesScreenViewModel @Inject constructor(
    private val loadSeries: LoadSeriesUseCase,
    private val saveNewSeriesUseCase: SaveNewSeriesUseCase,
) :
    ViewModel() {

    val state = mutableStateOf(ViewModelState())

    fun initData(id: Int) {
        state.value = state.value.copy(
            selectedRecipeId = id
        )
    }

    init {
        state.value = state.value.copy(
            enableExistSeriesButton = loadSeries().isNotEmpty(),
            listOfSeries = loadSeries())
    }

    fun onButtonNewSeriesClicked() {
        updateState(state.value.copy(
            showInfoDialog = true
        ))
    }

    fun onAddClicked() {
        saveNewSeriesUseCase(
            state.value.numberOfSeries
        )
        updateState(state.value.copy(
            showInfoDialog = false
        ))
    }

    fun onButtonExistingSeriesSelectionClicked() {
        updateState(state.value.copy(
            showInfoDialog2 = true))
    }

    private fun updateState(state: ViewModelState) {
        this.state.value = state
    }

    fun onNumberOfSeriesChanged(newValue: Int) {
        state.value = state.value.copy(
            numberOfSeries = newValue
        )
    }

    fun onExistSeriesDialogDismissed() {
        state.value = state.value.copy(
            showInfoDialog2 = false
        )
    }

    data class ViewModelState(
        val showInfoDialog: Boolean = false,
        val showInfoDialog2: Boolean = false,
        val numberOfSeries: Int = EMPTY_INT,
        val enableExistSeriesButton: Boolean = false,
        val listOfSeries: List<Seria> = emptyList(),
        val selectedRecipeId: Int = EMPTY_INT,
    )
}