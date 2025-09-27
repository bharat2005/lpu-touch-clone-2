package com.example.lputouch.ui.features.general.general_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.lputouch.ui.components.LoadingOverlay.LoadingOverlay
import com.example.lputouch.ui.components.generalTopBar.GeneralTopbar

@Composable
@ExperimentalMaterial3Api
fun GeneralScreen(navController: NavController, title : String) {

    Scaffold(
        topBar = { GeneralTopbar(navController, title = title ) }
    ) {
        innerpadding ->
        Column(
            modifier = Modifier.padding(innerpadding)
        ) {

        }
    }
    LoadingOverlay(isGeneral = true)

}