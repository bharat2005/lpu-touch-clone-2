package com.example.lputouch.ui.features.camera

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.lputouch.AppViewModal
import com.example.lputouch.ui.features.camera.camera_screen.CameraScreen
import com.google.accompanist.permissions.ExperimentalPermissionsApi

@ExperimentalPermissionsApi
fun NavGraphBuilder.cameraGraph(navController: NavController, viewModal: AppViewModal){
    navigation(
        startDestination = "camera_screen",
        route = "camera"
    ){
        composable("camera_screen/{food}") {
            backStackEntry ->
            val food = backStackEntry.arguments?.getString("food") ?: "food"
            CameraScreen(navController, food, viewModal) }
    }
}