package com.example.kaspukowaniev3.infostructure.repository

import android.media.DrmInitData
import androidx.compose.ui.text.font.FontWeight
import com.example.kaspukowaniev3.domain.model.Recipe
import com.example.kaspukowaniev3.domain.repository.RecipeRepository
import com.example.kaspukowaniev3.infostructure.database.DAO.RecipeDAO
import com.example.kaspukowaniev3.infostructure.database.DAO.SeriesDAO
import com.example.kaspukowaniev3.presentation.Utils
import javax.inject.Inject
import javax.inject.Singleton

@Singleton


class RecipeRepositoryImpl @Inject constructor(
    private val getRecipeDAO: RecipeDAO,
) : RecipeRepository {
    private val list = listOf(
        Recipe(
            id = 1,
            recipeName = "RAM/AML 5/5",
            doseWeight = 0.0002155,
            capsulesNet = 0.000076,
            capsulesGross = 0.0002915,
            sample = 340,
            valueForEfficiency = 73.93,
        ),
        Recipe(
            id = 2,
            recipeName = "RAM/AML 10/5",
            doseWeight = 0.0002205,
            capsulesNet = 0.000076,
            capsulesGross = 0.0002965,
            sample = 340,
            valueForEfficiency = 74.37,
        ),
        Recipe(
            id = 3,
            recipeName = "RAM/AML 5/10",
            doseWeight = 0.0002155,
            capsulesNet = 0.000076,
            capsulesGross = 0.0002915,
            sample = 340,
            valueForEfficiency = 73.93,
        ),
        Recipe(
            id = 4,
            recipeName = "RAM/AML 10/10",
            doseWeight = 0.0002205,
            capsulesNet = 0.000076,
            capsulesGross = 0.0002965,
            sample = 340,
            valueForEfficiency = 74.37,
        ),
        Recipe(
            id = 5,
            recipeName = "CAN/AML 16/10",
            doseWeight = 0.00032307,
            capsulesNet = 0.000076,
            capsulesGross = 0.00039907,
            sample = 340,
            valueForEfficiency = 80.96,
        ),
    )
    private var amountOfCapsules: String = Utils.EMPTY_STRING
    private var boxWeight: String = Utils.EMPTY_STRING
    private var weightOfPowder: String = Utils.EMPTY_STRING
    private var activeRecipeId: Int = 0

    override fun getRecipe(id: Int) = list.first { it.id == id }


    override fun getAll() = list
    override fun saveData(amountOfCapsules: String, boxWeight: String, weightOfPowder: String, activeRecipeId: Int) {
        this.amountOfCapsules = amountOfCapsules
        this.boxWeight = boxWeight
        this.weightOfPowder = weightOfPowder
        this.activeRecipeId = activeRecipeId

    }

    override fun getAmount(): String = amountOfCapsules
    override fun getBoxWeight(): String = boxWeight
    override fun getWeightOfPowder(): String = weightOfPowder
    override fun getActiveRecipeId(): Int = activeRecipeId
}