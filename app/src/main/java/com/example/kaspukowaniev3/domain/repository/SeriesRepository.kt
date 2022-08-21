package com.example.kaspukowaniev3.domain.repository

import com.example.kaspukowaniev3.domain.model.Seria
import com.example.kaspukowaniev3.infostructure.database.AppDatabase
import com.example.kaspukowaniev3.infostructure.database.entities.SeriesEntity

interface SeriesRepository {
    val db : AppDatabase
    suspend fun upsert (item: Seria) = db.getSeriesDAO()
        .upsert(SeriesEntity(item.id,item.numberOfSeries))
    fun getAllSeries(): List<Seria>
}