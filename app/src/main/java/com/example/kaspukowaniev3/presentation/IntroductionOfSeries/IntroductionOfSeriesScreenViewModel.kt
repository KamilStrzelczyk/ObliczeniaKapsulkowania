package com.example.kaspukowaniev3.presentation.IntroductionOfSeries

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class IntroductionOfSeriesScreenViewModel @Inject constructor() : ViewModel() {

    val state = mutableStateOf(ViewModelState())

    fun onButtonNewSeriesClicked() {
        updateState(state.value.copy(
            showInfoDialog = true
        ))
    }

    fun onAddClicked() {
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

    data class ViewModelState(
        var showInfoDialog: Boolean = false,
        val showInfoDialog2: Boolean = false,
        val numberOfSeries: Int = 0,
    )
}