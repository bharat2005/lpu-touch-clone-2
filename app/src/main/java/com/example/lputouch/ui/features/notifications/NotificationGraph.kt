package com.example.lputouch.ui.features.notifications

import android.app.Notification
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.lputouch.ui.features.notifications.notificaions_screen.NotificationsScreen

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.notificationGraph(navController: NavController){
    navigation(
        route = "notifications",
        startDestination = "notifications_screen"
    ){
        composable("notifications_screen") { NotificationsScreen(navController) }
    }
}