package com.example.kaspukowaniev3.presentation.RecipeDetailScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kaspukowaniev3.R
import com.example.kaspukowaniev3.presentation.Screen

@Composable

fun RecipeDetailScreen(
    navController: NavController,
    viewModel: RecipeDetailScreenViewModel,
) {
    val state = viewModel.state.value
    Scaffold(
        topBar = {

            TopAppBar(modifier = Modifier,
                title = {
                    Text(text = "Wprowadzenie danych serii")
                },
                actions = {
                    IconButton(onClick = { viewModel.onOpenDialogClicked() })
                    {
                        Icon(painter = painterResource(id = R.drawable.ic_help),
                            contentDescription = "sda")
                    }
                }
            )
        }


    ) {

        Column(

            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .verticalScroll(rememberScrollState())

        ) {

            TextField(
                maxLines = 1,
                value = state.weightOfPowder,
                onValueChange = { viewModel.onWeightChanged(it) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                label = { Text(state.weightHint) }
            )

            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                maxLines = 1,
                value = state.boxWeight,
                onValueChange = { viewModel.onBoxWeightChanged(it) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                label = { Text(state.boxHint) }
            )

            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                maxLines = 1,
                value = state.amountOfCapsules,
                onValueChange = { viewModel.onAmountChanged(it) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                label = { Text(state.amountOfCapsulesHint) }

            )

            Spacer(modifier = Modifier.height(20.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceAround,

                ) {
                TextField(
                    modifier = Modifier
                        .padding(5.dp)
                        .weight(2f),
                    readOnly = true,
                    value = state.boxAmountValue,
                    onValueChange = {},
                )

                TextField(
                    modifier = Modifier
                        .padding(5.dp)
                        .weight(1f),
                    readOnly = true,
                    value = state.boxAmount,
                    onValueChange = {},
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
            ) {

                TextField(
                    modifier = Modifier
                        .padding(5.dp)
                        .weight(2f),
                    readOnly = true,
                    value = state.amountSampleValue,
                    onValueChange = {},
                )

                TextField(
                    modifier = Modifier
                        .padding(5.dp)
                        .weight(1f),
                    readOnly = true,
                    value = state.boxSample,
                    onValueChange = {},
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    viewModel.save()
                    navController.navigate(Screen.CalculationsScreen.route)
                })
            {
                Text(state.buttonHint)
            }

        }
    }
    InfoDialog(state, viewModel::onDismissOpenDialog)

}

@Composable

fun InfoDialog(
    state: RecipeDetailScreenViewModel.ViewModelState,
    onDismissOpenDialog: () -> Unit,
) {
    if (state.showInfoDialog) {
        AlertDialog(
            onDismissRequest = {},
            title = {
                Text(text = "Dane serii")
            },
            text = {
                Column() {
                    Text(text = "Wybrana receptura : ${state.recipeName}")
                    Text(text = "Doza              : ${String.format("%.7f",state.doseWeight)}.kg")
                    Text(text = "Kapsułka netto    : ${String.format("%.7f",state.capsulesNet)}.kg")
                    Text(text = "Kapsułka brutto   : ${String.format("%.7f",state.capsulesGross)}.kg")
                    Text(text = "Ilość prób        : ${state.sample.toString()}.szt")
                }
            },
            buttons = {
                Row(
                    modifier = Modifier
                        .padding(all = 8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { onDismissOpenDialog() }
                    ) {
                        Text("Ok")
                    }
                }
            }
        )
    }
}