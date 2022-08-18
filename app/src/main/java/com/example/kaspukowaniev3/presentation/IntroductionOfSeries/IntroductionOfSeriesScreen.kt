package com.example.kaspukowaniev3.presentation.IntroductionOfSeries

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kaspukowaniev3.presentation.RecipeDetailScreen.InfoDialog
import com.example.kaspukowaniev3.presentation.RecipeDetailScreen.RecipeDetailScreenViewModel


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
            Button(onClick = { viewModel.onButtonNewSeriesClicked()}) {
                Text(text = "Nowa seria")
            }

            Spacer(modifier = Modifier.padding(10.dp))

            Button(onClick = { viewModel.onButtonExistingSeriesSelectionClicked()}) {
                Text(text = "Wybór istniejącej serii")
            }

        }
    }
    onButtonNewSeriesClicked(state, viewModel::onAddClicked)
    onButtonExistingSeriesSelectionClicked(state)
}

@Composable

fun onButtonNewSeriesClicked(
    state: IntroductionOfSeriesScreenViewModel.ViewModelState,
    onAddClicked: () -> Unit,
) {
    if (state.showInfoDialog) {
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
                    onValueChange = {},
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
                        onClick = { onAddClicked() }
                    ) {
                        Text(text = "Dodaj")
                    }
                }
            }
        )
    }
}


@Composable

fun onButtonExistingSeriesSelectionClicked(
    state: IntroductionOfSeriesScreenViewModel.ViewModelState,
) {
    if (state.showInfoDialog2) {
        AlertDialog(onDismissRequest = {},
            title = {
                Text(text = "Wybierz z istniejących serii")
            },
            text = {
                LazyColumn(contentPadding = PaddingValues(15.dp)) {

                }
            },
            buttons = {}
        )
    }
}
