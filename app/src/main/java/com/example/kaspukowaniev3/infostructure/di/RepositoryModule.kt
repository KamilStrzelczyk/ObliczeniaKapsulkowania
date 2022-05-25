package com.example.kaspukowaniev3.infostructure.di

import com.example.kaspukowaniev3.domain.repository.RecipeRepository
import com.example.kaspukowaniev3.infostructure.repository.RecipeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn (SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindsRecipeRepository (impl: RecipeRepositoryImpl) : RecipeRepository
}