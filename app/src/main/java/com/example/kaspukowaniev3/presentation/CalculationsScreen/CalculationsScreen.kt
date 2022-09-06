package com.example.kaspukowaniev3.presentation.CalculationsScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavController
import com.example.kaspukowaniev3.R

@Composable

fun CalculationsScreen(
    navController: NavController,
    calculationsViewModel: CalculationsScreenViewModel,
) {
    val state = calculationsViewModel.state.value
    Scaffold(
        topBar = {
            TopAppBar {
                Text(stringResource(id = R.string.topAppBarLabel))
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
                        .weight(2f)
                        .padding(5.dp),
                    value = stringResource(id = R.string.fullBoxesHint),
                    onValueChange = {},
                    readOnly = true,
                )

                TextField(
                    modifier = Modifier
                        .weight(1f)
                        .padding(5.dp),
                    value = state.fullBoxes,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    onValueChange = { calculationsViewModel.onFullBoxesChanged(it) },
                    label = { Text(stringResource(id = R.string.pc)) }
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                TextField(
                    modifier = Modifier
                        .weight(2f)
                        .padding(5.dp),
                    value = stringResource(id = R.string.restOfBoxesHint),
                    onValueChange = {},
                    readOnly = true,
                )

                TextField(
                    modifier = Modifier
                        .weight(1f)
                        .padding(5.dp),
                    value = state.restOfBoxes,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    onValueChange = { calculationsViewModel.onRestBoxesChanged(it) },
                    label = { Text(stringResource(id = R.string.kg)) }
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(stringResource(id = R.string.capsuleWeightsLabel))

            Spacer(modifier = Modifier.height(20.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                TextField(
                    modifier = Modifier
                        .weight(2f)
                        .padding(5.dp),
                    value = stringResource(id = R.string.capsulesNettHint),
                    onValueChange = {},
                    readOnly = true,
                )

                TextField(
                    modifier = Modifier
                        .weight(1f)
                        .padding(5.dp),
                    value = state.capsulesNett,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    onValueChange = { calculationsViewModel.onCapsulesNettChanged(it) },
                    label = { Text(stringResource(id = R.string.mg)) },
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                TextField(
                    modifier = Modifier
                        .weight(2f)
                        .padding(5.dp),
                    value = stringResource(id = R.string.capsulesGrossHint),
                    onValueChange = {},
                    readOnly = true,
                )

                TextField(
                    modifier = Modifier
                        .weight(1f)
                        .padding(5.dp),
                    value = state.capsulesGross,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    onValueChange = { calculationsViewModel.onCapsulesGrossChanged(it) },
                    label = { Text(stringResource(id = R.string.mg)) }
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(stringResource(id = R.string.processWasteLabel))

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                TextField(
                    modifier = Modifier
                        .weight(2f)
                        .padding(5.dp),
                    value = stringResource(id = R.string.wrongCapsulesHint),
                    onValueChange = {},
                    readOnly = true,
                )

                TextField(
                    modifier = Modifier
                        .weight(1f)
                        .padding(5.dp),
                    value = state.wrongCapsules,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    onValueChange = { calculationsViewModel.onWrongCapsulesChanged(it) },
                    label = { Text(stringResource(id = R.string.pc)) })
            }

            Spacer(modifier = Modifier.height(20.dp))


            Row(
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                TextField(
                    modifier = Modifier
                        .weight(2f)
                        .padding(5.dp),
                    value = stringResource(id = R.string.wrongCapsulesFromStartUpText),
                    onValueChange = {},
                    readOnly = true,
                )

                TextField(
                    modifier = Modifier
                        .weight(1f)
                        .padding(5.dp),
                    value = state.wrongCapsulesFromStartUp,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    onValueChange = { calculationsViewModel.onWrongCapsulesFromStartUpChanged(it) },
                    label = { Text(stringResource(id = R.string.kg)) })
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(stringResource(id = R.string.resultLabel))

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                TextField(
                    modifier = Modifier
                        .weight(2f)
                        .padding(5.dp),
                    value = stringResource(id = R.string.weightOfFinishedProductsText),
                    onValueChange = {},
                    readOnly = true,
                )

                TextField(
                    modifier = Modifier
                        .weight(1f)
                        .padding(5.dp),
                    value = state.weightOfFinishedProducts,
                    onValueChange = {},
                    readOnly = true,
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                TextField(
                    modifier = Modifier
                        .weight(2f)
                        .padding(5.dp),
                    value = stringResource(id = R.string.amountOfFillCapsulesHint),
                    onValueChange = {},
                    readOnly = true,
                )

                TextField(
                    modifier = Modifier
                        .weight(1f)
                        .padding(5.dp),
                    readOnly = true,
                    value = state.amountOfFillCapsules,
                    onValueChange = {},
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                TextField(
                    modifier = Modifier
                        .weight(2f)
                        .padding(5.dp),
                    value = stringResource(id = R.string.efficiencyText),
                    onValueChange = {},
                    readOnly = true,
                )

                TextField(
                    modifier = Modifier
                        .weight(1f)
                        .padding(5.dp),
                    value = state.efficiency,
                    onValueChange = {},
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                ) {
                    TextField(
                        modifier = Modifier
                            .weight(2f)
                            .padding(5.dp),
                        value = stringResource(id = R.string.restOfCapsulesHint),
                        onValueChange = {},
                        readOnly = true,
                    )

                    TextField(
                        modifier = Modifier
                            .weight(1f)
                            .padding(5.dp),
                        value = state.restOfCapsules,
                        onValueChange = {},
                        readOnly = true,
                    )
                }

            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                ) {
                    TextField(
                        modifier = Modifier
                            .weight(2f)
                            .padding(5.dp),
                        value = stringResource(id = R.string.wasteOfPowderHint),
                        onValueChange = {},
                        readOnly = true,
                    )

                    TextField(
                        modifier = Modifier
                            .weight(1f)
                            .padding(5.dp),
                        value = state.wasteOfPowder,
                        onValueChange = {},
                        readOnly = true,
                    )
                }

            }
            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = { /*TODO*/ }) {
                Text(stringResource(id = R.string.buttonText))
            }
        }
    }
}