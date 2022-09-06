package com.example.kaspukowaniev3.presentation

import android.app.Application
import com.example.kaspukowaniev3.infostructure.database.AppDatabase
import com.example.kaspukowaniev3.infostructure.database.DAO.RecipeDAO
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class MyApplication : Application() {
    @Inject
    lateinit var appDatabase: AppDatabase
    override fun onCreate() {
        super.onCreate()
        GlobalScope.launch {
            appDatabase.initializeDataBase()
        }

    }
}