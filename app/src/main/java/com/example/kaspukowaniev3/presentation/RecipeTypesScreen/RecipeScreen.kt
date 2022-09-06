package com.example.kaspukowaniev3.presentation.RecipeTypesScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kaspukowaniev3.presentation.RecipeRowData
import com.example.kaspukowaniev3.presentation.Screen
import com.example.kaspukowaniev3.R


@Composable


fun RecipeScreen(
    navController: NavController,
    viewModel: RecipeTypesViewModel,

    ) {
    val state = viewModel.state.value

    Scaffold(
        topBar = {
            TopAppBar {
                Text(stringResource(R.string.recipeChoice))

            }
        }
    ) {
        LazyColumn(contentPadding = PaddingValues(15.dp)) {
            items(state.recipes) {
                RecipeRow(it,
//                    onClick = { recipeId ->
//                        navController.navigate("${Screen.RecipeDetailScreen.route}/$recipeId")
                    onClick = { recipeId ->
                        navController.navigate("${Screen.IntroductionOfSeriesScreen.route}/$recipeId")
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
        Text(text = recipeRowData.name)

    }

}

