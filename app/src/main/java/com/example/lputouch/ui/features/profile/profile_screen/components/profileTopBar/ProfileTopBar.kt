package com.example.lputouch.ui.features.profile.profile_screen.components.profileTopBar

import android.text.Layout
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lputouch.ui.theme.Nunito
import com.skydoves.flexible.core.FlexibleSheetSize
import com.skydoves.flexible.core.FlexibleSheetState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@Composable
fun ProfileTopBar(navController: NavController, sheetState: SheetState, onShowSheet : ()-> Unit) {
    val scope = rememberCoroutineScope()

    CenterAlignedTopAppBar(
        title = { Text("Profile", fontFamily = Nunito, fontWeight = FontWeight.Medium, fontSize = 17.sp) },
        navigationIcon = {
            IconButton(
                onClick = {
                    if (navController.previousBackStackEntry != null) {
                        navController.popBackStack()
                    }
                }
            ) {
                Icon(Icons.Default.ArrowBack, contentDescription = null)
            }
        },
        actions = {
            Box(
                modifier = Modifier
                    .height(36.dp)
                    .width(46.dp)
                    .clickable(onClick ={
                        scope.launch {
                            onShowSheet()
                            delay(200)
                            sheetState.expand()
                        }
                    }, indication = null, interactionSource = remember { MutableInteractionSource() })
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color(0xFFF5821F)),
                contentAlignment = Alignment.Center
            ){
                Text("(QR)", fontFamily = Nunito, fontWeight = FontWeight.Medium, fontSize = 14.sp)
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color(0xFF323232),
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White
        )
    )

}