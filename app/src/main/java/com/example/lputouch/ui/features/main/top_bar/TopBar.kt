package com.example.lputouch.ui.features.main.top_bar

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lputouch.ui.theme.Nunito
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import com.example.lputouch.R
import kotlinx.coroutines.delay

@Composable
@ExperimentalMaterial3Api
fun TopBar(
    scope: CoroutineScope,
    drawerState: DrawerState,
    title: String,
    navController: NavController
) {

    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.White
        ),
        modifier = Modifier.shadow(10.dp),
        navigationIcon = {
                Image(
                    painterResource(R.drawable.menu), contentDescription = null,
                    modifier = Modifier
                        .size(48.dp)
                        .clickable(
                            onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            },
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() })

                )
        },
        title = { Text(title, fontFamily = Nunito, fontWeight = FontWeight.SemiBold, fontSize = 20.sp) },
        actions = {
            if (title == "Dashboard") {

                Image(
                    painterResource(R.drawable.bell), contentDescription = null,
                    modifier = Modifier
                        .size(48.dp)
                        .clickable(onClick = { navController.navigate("notifications_screen") }, indication = null, interactionSource = remember { MutableInteractionSource() })

                )

            }
        }

    )

}