package com.example.kaspukowaniev3.infostructure.repository

import android.media.DrmInitData
import androidx.compose.ui.text.font.FontWeight
import com.example.kaspukowaniev3.domain.model.Recipe
import com.example.kaspukowaniev3.domain.repository.RecipeRepository
import com.example.kaspukowaniev3.infostructure.database.DAO.RecipeDAO
import com.example.kaspukowaniev3.infostructure.database.DAO.SeriesDAO
import com.example.kaspukowaniev3.infostructure.mapper.RecipeMapper
import com.example.kaspukowaniev3.presentation.Utils
import javax.inject.Inject
import javax.inject.Singleton

@Singleton


class RecipeRepositoryImpl @Inject constructor(
    private val mapper: RecipeMapper,
    private val recipeDAO: RecipeDAO,
) : RecipeRepository {

    private var amountOfCapsules: String = Utils.EMPTY_STRING
    private var boxWeight: String = Utils.EMPTY_STRING
    private var weightOfPowder: String = Utils.EMPTY_STRING
    private var activeRecipeId: Int = 0

    override suspend fun getRecipe(id: Int) = mapper.toDomainModel(recipeDAO.getRecipe(id))


    override suspend fun getAll() = recipeDAO.getAllRecipes().map { mapper.toDomainModel(it) }
    override fun saveData(
        amountOfCapsules: String,
        boxWeight: String,
        weightOfPowder: String,
        activeRecipeId: Int,
    ) {
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