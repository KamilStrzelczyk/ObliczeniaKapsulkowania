package com.example.kaspukowaniev3.domain.model


data class Recipe(
    val id: Int,
    val recipeName: String,
    val doseWeight: Double,
    val capsulesNet: Double,
    val capsulesGross: Double,
    val sample: Int,
    val valueForEfficiency: Double,
)