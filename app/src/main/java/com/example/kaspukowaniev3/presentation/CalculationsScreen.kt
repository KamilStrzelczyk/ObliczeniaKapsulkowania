package com.example.kaspukowaniev3.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable

fun CalculationsScreen(
    navController: NavController,
    calculationsViewModel: CalculationsScreenViewModel,
) {
    val state = calculationsViewModel.state.value
    Scaffold(
        topBar = {
            TopAppBar {
                Text(text = "Rozliczenie kapsułkowania")
            }
        }
    ) {
        Column(verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .verticalScroll(rememberScrollState()))
        {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                TextField(
                    modifier = Modifier
                        .weight(2f),
                    value = "",
                    onValueChange = {},
                    readOnly = true,
                    label = { Text(text = state.fullBoxesHint)})

                TextField(
                    modifier = Modifier
                        .weight(1f),
                    value = "",
                    onValueChange = {},
                    label = { Text(text = "") })
            }

            Spacer(modifier = Modifier.height(20.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                TextField(
                    modifier = Modifier
                        .weight(2f),
                    value = "",
                    onValueChange = {},
                    readOnly = true,
                    label = { Text(text = state.restOfBoxesHint ) })

                TextField(
                    modifier = Modifier
                        .weight(1f),
                    value = "",
                    onValueChange = {},
                    label = { Text(text = "") })
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(text = "Wagi kapsułek")

            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "Netto") })

            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "Brutto") })

            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Wynik")
            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "Ilość odpadu") })

            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "Ilość wyprodukowanych kapsułek") })


            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "Wydajność") })

            Spacer(modifier = Modifier.height(20.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                TextField(
                    modifier = Modifier
                        .weight(2f),
                    value = "",
                    onValueChange = {},
                    readOnly = true,
                    label = { Text(text = "Pozostała ilość kapsułek") })

                TextField(
                    modifier = Modifier
                        .weight(1f),
                    value = "",
                    onValueChange = {},
                    label = { Text(text = "") })
            }


        }
    }
}