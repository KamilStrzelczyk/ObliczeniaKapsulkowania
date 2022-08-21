package com.example.kaspukowaniev3.domain.usecase

import com.example.kaspukowaniev3.domain.repository.SeriesRepository
import javax.inject.Inject

class LoadSeriesUseCase @Inject constructor(private val seriesRepository: SeriesRepository) {
    operator fun invoke() =
        seriesRepository.getAllSeries()
}