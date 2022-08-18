package com.example.kaspukowaniev3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kaspukowaniev3.presentation.CalculationsScreen.CalculationsScreen
import com.example.kaspukowaniev3.presentation.CalculationsScreen.CalculationsScreenViewModel
import com.example.kaspukowaniev3.presentation.IntroductionOfSeries.IntroductionOfSeriesScreen
import com.example.kaspukowaniev3.presentation.IntroductionOfSeries.IntroductionOfSeriesScreenViewModel
import com.example.kaspukowaniev3.presentation.RecipeDetailScreen.RecipeDetailScreen
import com.example.kaspukowaniev3.presentation.RecipeDetailScreen.RecipeDetailScreenViewModel
import com.example.kaspukowaniev3.presentation.RecipeTypesScreen.RecipeScreen
import com.example.kaspukowaniev3.presentation.RecipeTypesScreen.RecipeTypesViewModel
import com.example.kaspukowaniev3.presentation.Screen.*
import com.example.kaspukowaniev3.ui.theme.Kaspułkowaniev3Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val calculationsViewModel: CalculationsScreenViewModel by viewModels()
    private val viewModel: RecipeTypesViewModel by viewModels()
    private val detailViewModel: RecipeDetailScreenViewModel by viewModels()
    private val introductionOfSeriesScreenViewModel: IntroductionOfSeriesScreenViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kaspułkowaniev3Theme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = RecipeScreen.route
                    ) {
                        composable(
                            route = RecipeScreen.route
                        ) {
                            RecipeScreen(navController, viewModel)
                        }
                        //
                        composable(
                            route = "${IntroductionOfSeriesScreen.route}/{id}") {
                            IntroductionOfSeriesScreen(
                                navController, introductionOfSeriesScreenViewModel)
                        }
                        //
                        composable(
                            route = "${RecipeDetailScreen.route}/{id}",
                            arguments = listOf(navArgument("id") { type = NavType.IntType })
                        ) { navBackStackEntry ->
                            val id: Int = navBackStackEntry.arguments?.getInt("id") ?: 0
                            detailViewModel.initData(id)
                            RecipeDetailScreen(navController, detailViewModel)

                        }
                        composable(
                            route = CalculationsScreen.route) {
                            CalculationsScreen(navController, calculationsViewModel)
                        }

                    }
                }
            }
        }
    }
}
