package com.example.kaspukowaniev3.presentation.RecipeDetailScreen

import android.app.TimePickerDialog
import android.widget.TimePicker
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kaspukowaniev3.R
import com.example.kaspukowaniev3.presentation.Screen
import com.example.kaspukowaniev3.presentation.Utils
import java.util.*

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
                    Text(stringResource(id = R.string.IntroduceSeriesData))
                },
                actions = {
                    IconButton(onClick = { viewModel.onOpenInfoDialogClicked() })
                    {
                        Icon(painter = painterResource(id = R.drawable.ic_help),
                            Utils.EMPTY_STRING)
                    }
                    IconButton(onClick = { viewModel.onOpenTimeDialogClicked() })
                    {
                        Icon(painter = painterResource(id = R.drawable.ic_time),
                            Utils.EMPTY_STRING)
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
                label = { Text(stringResource(id = R.string.weightText)) }
            )

            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                maxLines = 1,
                value = state.boxWeight,
                onValueChange = { viewModel.onBoxWeightChanged(it) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                label = { Text(stringResource(id = R.string.boxText)) }
            )

            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                maxLines = 1,
                value = state.amountOfCapsules,
                onValueChange = { viewModel.onAmountChanged(it) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                label = { Text(stringResource(id = R.string.amountOfCapsulesText)) }

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
                    value = stringResource(id = R.string.boxAmountValueText),
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
                    value = stringResource(id = R.string.amountSampleValueText),
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

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
            ) {

                TextField(
                    modifier = Modifier
                        .padding(5.dp)
                        .weight(2f),
                    readOnly = true,
                    value = stringResource(id = R.string.theoreticalMassText),
                    onValueChange = {},
                )

                TextField(
                    modifier = Modifier
                        .padding(5.dp)
                        .weight(1f),
                    readOnly = true,
                    value = state.theoreticalMass,
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
                Text(stringResource(id = R.string.buttonHintText))
            }

        }
    }
    InfoDialog(state, viewModel::onDismissOpenDialog)
    TimeDialog(state, viewModel)
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
                Text(stringResource(id = R.string.DataSeries))
            },
            text = {
                Column() {
                    Text(text = "Wybrana receptura : ${state.recipeName}")
                    Text(text = "Doza              : ${String.format("%.7f", state.doseWeight)}.kg")
                    Text(text = "Kapsułka netto    : ${
                        String.format("%.7f",
                            state.capsulesNet)
                    }.kg")
                    Text(text = "Kapsułka brutto   : ${
                        String.format("%.7f",
                            state.capsulesGross)
                    }.kg")
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
                        Text(stringResource(id = R.string.OK))
                    }
                }
            }
        )
    }
}

@Composable

fun TimeDialog(
    state: RecipeDetailScreenViewModel.ViewModelState,
    viewModel: RecipeDetailScreenViewModel,
) {
    if (state.showTimeDialog) {
        AlertDialog(
            onDismissRequest = {},
            title = {
                Text(stringResource(id = R.string.BoxesTime))
            },
            text =
            {
                Column(modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    TimePickerDialog(state, viewModel)

                    Button(onClick = { viewModel.onOpenTimePickerDialog() },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58))) {
                        Text(stringResource(id = R.string.ChoiceTime), color = Color.White)
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
                            value = stringResource(id = R.string.BoxTime),
                            onValueChange = {},
                        )

                        TextField(
                            modifier = Modifier
                                .padding(5.dp)
                                .weight(1f),
                            maxLines = 1,
                            value = state.boxTime,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            onValueChange = { viewModel.onBoxTimeChanged(it) },
                            label = { }
                        )
                    }
                    Spacer(modifier = Modifier.size(10.dp))

                    LazyColumn(modifier = Modifier
                        .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center) {
                        itemsIndexed(state.listTimeBox) { index, item ->
                            Text("${index + 1}.$item")
                        }
                    }
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
                        onClick = { viewModel.onDismissTimeDialogClicked() }
                    ) {
                        Text(stringResource(id = R.string.OK))
                    }
                }

            }
        )
    }
}

@Composable
fun TimePickerDialog(
    state: RecipeDetailScreenViewModel.ViewModelState,
    viewModel: RecipeDetailScreenViewModel,
) {
    val mContext = LocalContext.current
    val timepicker =
        TimePickerDialog(
            mContext,
            { view: TimePicker, mHour: Int, mMinute: Int ->
                viewModel.onTimeChanged(
                    mHour,
                    mMinute)
            },
            Calendar.HOUR_OF_DAY,
            Calendar.MINUTE,
            true,
        )
    timepicker.setOnDismissListener {
        viewModel.onDismissTimePickerDialog()
    }
    if (state.showTimePickerDialog) {
        timepicker.show()
    }
}


