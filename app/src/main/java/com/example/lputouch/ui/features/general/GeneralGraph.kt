package com.example.lputouch.ui.features.general

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.lputouch.ui.features.general.general_screen.GeneralScreen

@ExperimentalMaterial3Api
fun NavGraphBuilder.generalGraph(navController: NavController){
    navigation(
        startDestination = "general_screen",
        route = "general"
    ){
        composable("general_screen/{title}"
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: "No title"
            GeneralScreen(navController, title)
        }
    }
}