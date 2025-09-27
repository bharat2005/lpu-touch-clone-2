package com.example.lputouch.ui.features.main

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lputouch.ui.features.main.screens.dashboard_screen.DashboardScreen
import com.example.lputouch.ui.features.main.bottom_bar.BottomBar
import com.example.lputouch.ui.features.main.bottom_bar.tabsList
import com.example.lputouch.ui.features.main.screens.happening_screen.HappeningScreen
import com.example.lputouch.ui.features.main.screens.quickquiz_screen.QuickQuizScreen
import com.example.lputouch.ui.features.main.screens.rms_screen.RMSScreen
import com.example.lputouch.ui.features.main.side_drawer.SideDrawer
import com.example.lputouch.ui.features.main.top_bar.TopBar
import com.google.accompanist.navigation.animation.AnimatedNavHost

@ExperimentalMaterial3Api
fun NavGraphBuilder.mainGraph(navController: NavHostController){
    composable("main",
        ){MainScreen(navController)}
}


@OptIn(ExperimentalAnimationApi::class)
@Composable
@ExperimentalMaterial3Api
fun MainScreen(navController: NavHostController){
    var bottomNavController : NavHostController = rememberNavController()
    val navBackStackEntry = bottomNavController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    var title = tabsList.find { it.route == currentRoute }?.title ?: "LPUTouch"

    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var scope = rememberCoroutineScope()

    val focusManger = LocalFocusManager.current

    val keyboardController : SoftwareKeyboardController? = LocalSoftwareKeyboardController.current

    LaunchedEffect(drawerState.isClosed) {
        if(drawerState.isClosed){
            keyboardController?.hide()
            focusManger.clearFocus()
        }
    }



    ModalNavigationDrawer(
    drawerState = drawerState, drawerContent = { SideDrawer(navController, drawerState, focusManger, keyboardController) }

    ) {
        Scaffold(
            topBar = { TopBar(scope, drawerState, title, navController) },
            bottomBar = { BottomBar(currentRoute, bottomNavController) },
        ) { innerpadding ->
            NavHost(
                startDestination = "dashboard",
                navController = bottomNavController,
                modifier = Modifier.padding(innerpadding)
            ) {
                composable("dashboard",
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None },

                ) { DashboardScreen(navController) }

                composable("happening",
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None },
                    ) { HappeningScreen(navController) }

                composable("rms",
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None },
                    ) { RMSScreen(navController) }

                composable("quickquiz",
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None },
                    ) { QuickQuizScreen(navController) }

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
fun MyPreview(){
    MainScreen(navController = rememberNavController())
}



























