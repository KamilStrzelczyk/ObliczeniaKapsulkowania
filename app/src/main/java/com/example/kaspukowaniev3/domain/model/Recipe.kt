package com.example.kaspukowaniev3.domain.model


data class Recipe(
    val id: Int,
    val recipeName: String,
    val doseWeight: Double,
    var capsulesNet: Int,
    var capsulesGross: Int,
)