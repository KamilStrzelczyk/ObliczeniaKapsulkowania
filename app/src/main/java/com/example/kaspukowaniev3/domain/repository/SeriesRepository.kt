package com.example.kaspukowaniev3.domain.repository

import com.example.kaspukowaniev3.domain.model.Seria

interface SeriesRepository {
    fun getAllSeries(): List<Seria>
}