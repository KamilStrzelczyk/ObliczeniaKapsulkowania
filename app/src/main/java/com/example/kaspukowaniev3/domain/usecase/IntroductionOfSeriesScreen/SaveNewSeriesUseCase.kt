package com.example.kaspukowaniev3.domain.usecase.IntroductionOfSeriesScreen

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class SaveNewSeriesUseCase @Inject constructor() {
    operator fun invoke(
        numberOfSeries: Int,
    ) {
        GlobalScope.launch { }
    }
}