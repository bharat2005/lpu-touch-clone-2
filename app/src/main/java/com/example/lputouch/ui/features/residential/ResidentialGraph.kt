package com.example.lputouch.ui.features.residential

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.lputouch.ui.features.residential.residential_screen.ResidentialScreen

@ExperimentalMaterial3Api
fun NavGraphBuilder.residentailGraph(navController: NavController){
    navigation(
        startDestination = "residential_screen",
        route = "residetial"
    ){
        composable("residential_screen") { ResidentialScreen(navController) }
    }
}