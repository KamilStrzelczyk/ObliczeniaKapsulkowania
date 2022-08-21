package com.example.kaspukowaniev3.domain.model

import dagger.Binds
import javax.inject.Inject

data class Seria @Inject constructor(
    val id : Int,
    val recipe: Recipe,
    val numberOfSeries: String,
)
