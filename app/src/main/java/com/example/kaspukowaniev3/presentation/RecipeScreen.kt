package com.example.kaspukowaniev3.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kaspukowaniev3.domain.usecase.GetAllRecipesUseCase


@Composable


fun RecipeScreen(
    navController: NavController,
    viewModel: RecipeTypesViewModel,

    ) {

    Scaffold(
        topBar = {
            TopAppBar {
                Text(text = "Kapsułkowanie")

            }
        }
    ) {
        LazyColumn(contentPadding = PaddingValues(15.dp)) {
            items(viewModel.loadData()) {
                RecipeRow(it,
                    onClick = { recipeId ->
                        navController.navigate("${Screen.RecipeDetailScreen.route}/$recipeId")
                    })

            }
        }
    }


}

@Composable
fun RecipeRow(
    recipeRowData: RecipeRowData,
    onClick: (Int) -> Unit,
) {
    Column(
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth()
            .clickable { onClick(recipeRowData.id) },
        verticalArrangement = Arrangement.Center
    ) {
        androidx.compose.material.Text(text = recipeRowData.name)

    }

}

