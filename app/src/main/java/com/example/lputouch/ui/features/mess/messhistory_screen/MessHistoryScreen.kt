package com.example.lputouch.ui.features.mess.messhistory_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.lputouch.ui.components.LoadingOverlay.LoadingOverlay
import com.example.lputouch.ui.components.generalTopBar.GeneralTopbar

@ExperimentalMaterial3Api
@Composable
fun MessHistoryScreen(navController: NavController) {
    Scaffold(
        topBar = { GeneralTopbar(navController, title = "Meal History" ) }
    ) {
        paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {

        }
        LoadingOverlay(isGeneral = false)
    }
}