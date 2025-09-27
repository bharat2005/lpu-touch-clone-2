package com.example.lputouch.ui.features.profile

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.lputouch.ui.features.profile.profile_screen.ProfileScreen

@ExperimentalMaterial3Api
fun NavGraphBuilder.profileGraph(navController: NavController){
    navigation(
        startDestination = "profile_screen",
        route = "profile"
    ){
        composable("profile_screen",

            ) { ProfileScreen(navController) }
        composable("test") { TestScreen() }

    }
}