package com.example.kaspukowaniev3.domain.usecase.IntroductionOfSeriesScreen

import com.example.kaspukowaniev3.domain.model.Seria
import com.example.kaspukowaniev3.domain.repository.SeriesRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class SaveNewSeriesUseCase @Inject constructor(
    private val repository: SeriesRepository
) {
    fun upsertdata(item: Seria) = GlobalScope.launch {
        repository.upsert(item)
    }
}