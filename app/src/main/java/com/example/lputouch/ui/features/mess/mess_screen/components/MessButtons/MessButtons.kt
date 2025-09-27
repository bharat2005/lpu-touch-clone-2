package com.example.lputouch.ui.features.mess.mess_screen.components.MessButtons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun MessButtons(navController: NavController) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(listOf<String>("BreakFast", "Lunch", "Dinner")){
            Button(onClick = {navController.navigate("camera_screen/${it}")
            }) {
                Text(it)
            }

        }
    }

}