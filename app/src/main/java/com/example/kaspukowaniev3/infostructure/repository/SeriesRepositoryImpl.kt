package com.example.kaspukowaniev3.infostructure.repository

import com.example.kaspukowaniev3.domain.model.Recipe
import com.example.kaspukowaniev3.domain.model.Seria
import com.example.kaspukowaniev3.domain.repository.SeriesRepository
import com.example.kaspukowaniev3.infostructure.database.DAO.SeriesDAO
import javax.inject.Inject


class SeriesRepositoryImpl @Inject constructor(
    private val getSeriesDAO: SeriesDAO,
) :
    SeriesRepository {
    override fun getAllSeries(): List<Seria> {
        return listOf(
            Seria(
                1,
                Recipe(
                    id = 1,
                    recipeName = "RAM/AML 5/5",
                    doseWeight = 0.0002155,
                    capsulesNet = 0.000076,
                    capsulesGross = 0.0002915,
                    sample = 340,
                    valueForEfficiency = 73.93,
                ),
            )
        )
    }
}
