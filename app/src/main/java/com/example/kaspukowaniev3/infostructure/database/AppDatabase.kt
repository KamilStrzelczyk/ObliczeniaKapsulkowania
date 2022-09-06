package com.example.kaspukowaniev3.infostructure.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kaspukowaniev3.domain.model.Recipe
import com.example.kaspukowaniev3.infostructure.database.DAO.RecipeDAO
import com.example.kaspukowaniev3.infostructure.database.entities.RecipeEntity
import com.example.kaspukowaniev3.infostructure.database.DAO.SeriesDAO
import com.example.kaspukowaniev3.infostructure.database.entities.SeriesEntity

@Database(
    entities = [
        RecipeEntity::class,
        SeriesEntity::class,
    ],
    version = 1,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getRecipeDAO(): RecipeDAO
    abstract fun getSeriesDAO(): SeriesDAO
    suspend fun initializeDataBase() {
        getRecipeDAO().insert(
            RecipeEntity(
                1,
                "RAM/AML 5/5",
                0.0002155,
                0.000076,
                0.0002915,
                340,
                73.93,
            ),
            RecipeEntity(
                2,
                "RAM/AML 10/5",
                0.0002205,
                0.000076,
                0.0002965,
                340,
                74.37,
            ),
            RecipeEntity(
                3,
                "RAM/AML 5/10",
                0.0002155,
                0.000076,
                0.0002915,
                340,
                73.93,
            ),
            RecipeEntity(
                4,
                "RAM/AML 10/10",
                0.0002205,
                0.000076,
                0.0002965,
                340,
                74.37,
            ),
            RecipeEntity(
                5,
                "CAN/AML 16/10",
                0.00032307,
                0.000076,
                0.00039907,
                340,
                80.96,
            )
        )
    }
}
