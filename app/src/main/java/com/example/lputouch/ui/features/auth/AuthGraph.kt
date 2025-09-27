package com.example.lputouch.ui.features.auth

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.lputouch.AppViewModal
import com.example.lputouch.ui.features.auth.login_screen.LoginScreen


fun NavGraphBuilder.authGraph(navController : NavHostController,viewModal : AppViewModal){
    navigation(
        startDestination = "login",
        route = "auth"
    ) {

        composable(
            route ="login",
        ){
                LoginScreen(navController, viewModal)
        }


    }

}