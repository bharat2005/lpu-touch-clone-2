package com.example.lputouch.ui.features.main.screens.happening_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lputouch.data.source.HappeningsList
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.delay
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import com.example.lputouch.ui.theme.Nunito
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator


@Composable
fun HappeningScreen(navController: NavController) {
    var refreshing by remember { mutableStateOf(false) }


    LaunchedEffect(refreshing) {
        if (refreshing) {
            delay(2000)
            refreshing = false
        }
    }


    SwipeRefresh(
        state = rememberSwipeRefreshState(refreshing),
        onRefresh = { refreshing = true },
        indicator = { state, trigger ->
            SwipeRefreshIndicator(
                contentColor = Color(0xFFFD7E14),
                backgroundColor = Color.White,
                state = state,
                refreshTriggerDistance = trigger
            )
        }
    ) {
        Spacer( modifier = Modifier.height(28.dp))
        LazyColumn(
            modifier = Modifier.fillMaxSize().background(Color(0xFFF8F8F8)),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(HappeningsList.getHappeningsList()) { item ->
                Row(
                    modifier = Modifier.fillMaxWidth().background(Color.White).padding(18.dp),
                    horizontalArrangement = Arrangement.spacedBy(13.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painterResource(item.image),
                        contentDescription = null,
                        modifier = Modifier.size(56.dp)
                            .clip(RoundedCornerShape(6.dp)),
                        contentScale = ContentScale.Crop
                    )

                    Text(item.title, fontSize = 15.sp, fontFamily = Nunito, fontWeight = FontWeight.Normal, color = Color(
                        0xFF464646
                    ),
                        lineHeight = 16.sp
                    )
                }
            }
        }
    }
}




@Preview(showSystemUi = true)
@Composable
fun MyPreview(){
    HappeningScreen(navController = rememberNavController())
}






















