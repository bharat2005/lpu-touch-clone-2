package com.example.lputouch.ui.features.main.screens.dashboard_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.pullToRefresh
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.lputouch.ui.features.main.screens.dashboard_screen.components.OptionsSection.OptionsSection
import com.example.lputouch.ui.features.main.screens.dashboard_screen.components.TimeTableSection.TimeTableSection
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.delay

@Composable
@ExperimentalMaterial3Api
fun DashboardScreen(navController: NavController) {
    var refreshing by remember { mutableStateOf(false) }

    LaunchedEffect(refreshing) {
        if(refreshing){
            delay(2000)
            refreshing = false
        }
    }

    SwipeRefresh(
        state = rememberSwipeRefreshState(refreshing),
        onRefresh = {refreshing = true},
        indicator = { state, trigger ->
            SwipeRefreshIndicator(
                contentColor = Color(0xFFFD7E14),
                state = state,
                refreshTriggerDistance = trigger,
                backgroundColor = Color.White

            )
        }

    ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize().background(Color.White),
              //  verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                item {
                    TimeTableSection()
                }
                item {
                    OptionsSection(navController)
                }


            }


    }
}

@ExperimentalMaterial3Api
@Preview(showSystemUi = true)
@Composable
fun MyPreview() {
    DashboardScreen(navController = rememberNavController())
}
