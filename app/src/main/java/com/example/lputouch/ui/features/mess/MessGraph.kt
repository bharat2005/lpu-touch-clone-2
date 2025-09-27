package com.example.lputouch.ui.features.mess

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.lputouch.AppViewModal
import com.example.lputouch.ui.features.mess.mess_screen.MessScreen
import com.example.lputouch.ui.features.mess.messhistory_screen.MessHistoryScreen

@ExperimentalMaterial3Api
fun NavGraphBuilder.messGraph(navController: NavController, viewModal: AppViewModal){
    navigation(
        startDestination = "mess_screen",
        route = "mess"
    ){
        composable("mess_screen") { MessScreen(navController, viewModal) }

        composable("messhistory_screen") { MessHistoryScreen(navController) }
    }
}