package com.example.kaspukowaniev3.infostructure.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "recipe_table")
data class RecipeEntity(
    @PrimaryKey val id: Int,

    @ColumnInfo(name = "recipe_Name") val recipeName: String,
    @ColumnInfo(name = "dose_Weight") val doseWeight: Double,
    @ColumnInfo(name = "capsules_Net") val capsulesNet: Double,
    @ColumnInfo(name = "capsules_Gross") val capsulesGross: Double,
    @ColumnInfo(name = "sample") val sample: Int,
)
