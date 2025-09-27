package com.example.lputouch.ui.features.main.bottom_bar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.lputouch.ui.theme.Nunito
import com.example.lputouch.R

data class Tab(
    val route : String,
    val icon : Int,
    val title : String,
)

val tabsList : List<Tab> = listOf(
    Tab(route ="dashboard", title = "Dashboard", icon = R.drawable.grid_view_24dp_1f1f1f_fill0_wght400_grad0_opsz24),
    Tab(route ="happening", title = "Happenings", icon = R.drawable.feed_24dp_1f1f1f),
    Tab(route ="rms", title = "RMS", icon = R.drawable.edit_square_24dp_1f1f1f_fill0_wght400_grad0_opsz24),
    Tab(route ="quickquiz", title = "Quick Quiz", icon = R.drawable.format_list_bulleted_24dp_1f1f1f_fill0_wght400_grad0_opsz24),

    )

@Composable
fun BottomBar(currentRoute : String?, navController : NavController){


    BottomAppBar(
        containerColor = Color.White,
        modifier = Modifier.height(98.dp)
    ) {
        tabsList.forEach {
                tab ->
            NavigationBarItem(
                modifier = Modifier.weight(1f),
                selected = tab.route == currentRoute,
                onClick = {
                    navController.navigate(tab.route){
                        popUpTo(navController.graph.findStartDestination().id){
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                label = null,
                icon = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Icon(
                            painterResource(tab.icon),
                            contentDescription = null,
                            modifier = Modifier.size(23.dp)
                        )

                        Text(tab.title, fontFamily = Nunito, fontWeight = FontWeight.Normal, fontSize = 12.sp, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)

                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFFFD7E14),
                    unselectedIconColor = Color.Gray,
                    selectedTextColor = Color(0xFFFD7E14),
                    unselectedTextColor = Color.Gray,
                    indicatorColor = Color.Transparent
                )
            )
        }

    }
}

