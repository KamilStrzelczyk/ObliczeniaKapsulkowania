package com.example.kaspukowaniev3.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kaspukowaniev3.domain.usecase.GetAllRecipesUseCase


@Composable

fun RecipeScreen(viewModel: RecipeTypesViewModel) {

    LazyColumn(contentPadding = PaddingValues(15.dp)) {
        items(viewModel.loadData()) {
            RecipeRow(it, viewModel::onClicked)

        }
    }

}

@Composable
fun RecipeRow(recipeRowData: RecipeRowData, onClick: (Int) -> Unit) {
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

