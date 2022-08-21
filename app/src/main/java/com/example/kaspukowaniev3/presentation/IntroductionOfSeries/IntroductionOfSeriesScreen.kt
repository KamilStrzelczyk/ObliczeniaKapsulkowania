package com.example.kaspukowaniev3.presentation.IntroductionOfSeries

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kaspukowaniev3.domain.model.Recipe
import com.example.kaspukowaniev3.domain.model.Seria
import com.example.kaspukowaniev3.presentation.Screen


@Composable

fun IntroductionOfSeriesScreen(
    navController: NavController,
    viewModel: IntroductionOfSeriesScreenViewModel,
) {
    val state = viewModel.state.value
    Scaffold(
        topBar = {
            TopAppBar {
                Text(text = "Wybor serii")

            }
        }) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)) {
            Button(onClick = { viewModel.onButtonNewSeriesClicked() }) {
                Text(text = "Nowa seria")
            }

            Spacer(modifier = Modifier.padding(10.dp))

            Button(
                onClick = { viewModel.onButtonExistingSeriesSelectionClicked() },
                enabled = state.enableExistSeriesButton) {
                Text(text = "Wybór istniejącej serii")
            }

        }
    }
    if (state.showInfoDialog) {
        NewSeriesDialog(
            state,
            viewModel::onAddClicked,
            viewModel::onNumberOfSeriesChanged,
            navController,
        )
    }
    if (state.showInfoDialog2) {
        ExistingSeriesDialog(
            viewModel::onExistSeriesDialogDismissed,
            state.listOfSeries,
            state.selectedRecipeId,
            navController,
        )
    }
}

@Composable
private fun NewSeriesDialog(
    state: IntroductionOfSeriesScreenViewModel.ViewModelState,
    onAddClicked: () -> Unit,
    onValueChange: (Int) -> Unit,
    navController: NavController,
) {
    AlertDialog(
        onDismissRequest = {},
        title = {
            Text("Wprowadz nową serie")
        },

        text = {
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                maxLines = 1,
                value = state.numberOfSeries.toString(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                onValueChange = { newValue -> onValueChange(newValue.toInt()) },
            )
        },
        buttons = {
            Row(
                modifier = Modifier
                    .padding(all = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        onAddClicked()
                        navController.navigate("${Screen.RecipeDetailScreen.route}/${state.selectedRecipeId}")
                    }
                ) {
                    Text(text = "Dodaj")
                }
            }
        }
    )
}

@Composable
private fun ExistingSeriesDialog(
    onDismiss: () -> Unit,
    series: List<Seria>,
    recipeId: Int,
    navController: NavController,
) {
    AlertDialog(onDismissRequest = { onDismiss() },
        title = {
            Text(text = "Wybierz z istniejących serii")
        },
        text = {
            LazyColumn(
                contentPadding = PaddingValues(15.dp))
            {
                items(series) {
                    Text(modifier = Modifier
                        .clickable { navController.navigate("${Screen.RecipeDetailScreen.route}/$recipeId") },
                        text = it.id.toString())
                }
            }
        },
        buttons = {}
    )
}
