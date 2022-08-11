package com.example.kaspukowaniev3.infostructure.repository

import com.example.kaspukowaniev3.domain.repository.SeriesRepository
import com.example.kaspukowaniev3.infostructure.database.DAO.SeriesDAO
import javax.inject.Inject


class SeriesRepositoryImpl @Inject constructor(
    private val getSeriesDAO: SeriesDAO,
) :
    SeriesRepository {
}
