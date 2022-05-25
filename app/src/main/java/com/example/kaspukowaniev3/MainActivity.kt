package com.example.kaspukowaniev3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kaspukowaniev3.presentation.RecipeDetailScreen
import com.example.kaspukowaniev3.presentation.RecipeScreen
import com.example.kaspukowaniev3.presentation.RecipeTypesViewModel
import com.example.kaspukowaniev3.ui.theme.Kaspułkowaniev3Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: RecipeTypesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kaspułkowaniev3Theme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    var navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = com.example.kaspukowaniev3.presentation.Screen.RecipeScreen.route
                    ) {
                        composable(
                            route = com.example.kaspukowaniev3.presentation.Screen.RecipeScreen.route
                        ){
                            RecipeScreen(viewModel)
                        }
                        composable(
                            route = com.example.kaspukowaniev3.presentation.Screen.RecipeDetailScreen.route
                        ){
                          RecipeDetailScreen()
                        }
                    }
                    //RecipeScreen(viewModel)
                }
            }
        }
    }
}
