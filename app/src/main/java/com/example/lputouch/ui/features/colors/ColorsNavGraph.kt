package com.example.lputouch.ui.features.colors

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


fun NavGraphBuilder.colorsNavGraph(navController: NavController){
    composable("color_screen") {
        ColorsScreen(navController)
    }

}