package com.example.kaspukowaniev3.infostructure.mapper

import com.example.kaspukowaniev3.domain.model.Recipe
import com.example.kaspukowaniev3.infostructure.database.entities.RecipeEntity
import javax.inject.Inject

class RecipeMapper @Inject constructor() {
    fun toDomainModel(entity: RecipeEntity) = Recipe(
        id = entity.id,
        recipeName = entity.recipeName,
        doseWeight = entity.doseWeight,
        capsulesNet = entity.capsulesNet,
        capsulesGross = entity.capsulesGross,
        sample = entity.sample,
        valueForEfficiency = entity.valueForEfficiency,
    )

    fun toEntity(recipe: Recipe) = RecipeEntity(
        id = recipe.id,
        recipeName = recipe.recipeName,
        doseWeight = recipe.doseWeight,
        capsulesGross = recipe.capsulesGross,
        capsulesNet = recipe.capsulesNet,
        sample = recipe.sample,
        valueForEfficiency = recipe.valueForEfficiency,
    )
}