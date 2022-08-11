package com.example.kaspukowaniev3.infostructure.di

import android.content.Context
import androidx.room.Room
import com.example.kaspukowaniev3.infostructure.database.AppDatabase
import com.example.kaspukowaniev3.infostructure.database.DAO.RecipeDAO
import com.example.kaspukowaniev3.infostructure.database.DAO.SeriesDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    fun provideRecipeDao(appDatabase: AppDatabase): RecipeDAO {
        return appDatabase.getRecipeDAO()
    }

    @Provides
    fun provideSeriesDao(appDatabase: AppDatabase): SeriesDAO {
        return appDatabase.getSeriesDAO()
    }

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "RssReader"
        ).build()
    }
}