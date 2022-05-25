package com.example.kaspukowaniev3.infostructure.repository

import com.example.kaspukowaniev3.domain.model.Recipe
import com.example.kaspukowaniev3.domain.repository.RecipeRepository
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor() : RecipeRepository {
    override fun getAll(): List<Recipe> {

        val recipe1 = Recipe(
        id = 1,
        recipeName = "RAM/AML 5/5",
        doseWeight = 10.0,
        capsulesNet = 5,
        capsulesGross = 1, )

        return listOf(

            recipe1,

            recipe1,

            Recipe(
                id = 2,
                recipeName = "RAM/AML 10/5",
                doseWeight = 5.0,
                capsulesNet = 2,
                capsulesGross = 2,
            ))
    }
}