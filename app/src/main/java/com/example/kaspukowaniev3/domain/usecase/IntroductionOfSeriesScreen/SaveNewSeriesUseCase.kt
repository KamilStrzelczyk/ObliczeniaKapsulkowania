package com.example.kaspukowaniev3.domain.usecase.IntroductionOfSeriesScreen

import com.example.kaspukowaniev3.infostructure.database.DAO.SeriesDAO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class SaveNewSeriesUseCase @Inject constructor( seriesDAO: SeriesDAO ) {
    operator fun invoke(
        numberOfSeries: Int,
    ) {
        GlobalScope.launch { }
    }
}