package com.example.kaspukowaniev3.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable

fun CalculationsScreen(
    navController: NavController,
    calculationsViewModel: CalculationsScreenViewModel,
) {
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
                .padding(20.dp)) {

            TextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "Ilość wyprodukowanych kapsułek") })

            Spacer(modifier = Modifier.height(20.dp))

            TextField(value = "", onValueChange = {},
                label = { Text(text = "Ilość odpadu") })
            
            Spacer(modifier = Modifier.height(20.dp))
            
            Text(text = "Wydajność")

            Spacer(modifier = Modifier.height(20.dp))

            Text(text = "Pozostała ilość kapsułek")
        }
    }
}