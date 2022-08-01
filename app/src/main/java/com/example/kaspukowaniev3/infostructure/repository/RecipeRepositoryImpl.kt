package com.example.kaspukowaniev3.infostructure.repository

import android.media.DrmInitData
import androidx.compose.ui.text.font.FontWeight
import com.example.kaspukowaniev3.domain.model.Recipe
import com.example.kaspukowaniev3.domain.repository.RecipeRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton


class RecipeRepositoryImpl @Inject constructor() : RecipeRepository {
    private val list = listOf(
        Recipe(
            id = 1,
            recipeName = "RAM/AML 5/5",
            doseWeight = 0.0002205,
            capsulesNet = 0.000076,
            capsulesGross = 0.0002965,
            sample = 340,
        ),
        Recipe(
            id = 2,
            recipeName = "RAM/AML 10/5",
            doseWeight = 0.000210,
            capsulesNet = 0.000075,
            capsulesGross = 0.000285,
            sample = 340,
        ),
        Recipe(
            id = 3,
            recipeName = "RAM/AML 5/10",
            doseWeight = 0.000215,
            capsulesNet = 0.000023,
            capsulesGross = 0.000238,
            sample = 340,
        ),
        Recipe(
            id = 4,
            recipeName = "RAM/AML 10/10",
            doseWeight = 0.000200,
            capsulesNet = 0.000075,
            capsulesGross = 0.000270,
            sample = 340,
        ),
    )
    var amountOfCapsules: String = ""
    var boxWeight: String = ""
    override fun getRecipe(id: Int) = list.first { it.id == id }


    override fun getAll() = list
    override fun saveData(amountOfCapsules: String, boxWeight: String) {
        this.amountOfCapsules = amountOfCapsules
        this.boxWeight = boxWeight

    }

    override fun getAmount(): String = amountOfCapsules
}