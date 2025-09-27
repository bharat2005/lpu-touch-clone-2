package com.example.lputouch.ui.features.auth.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.example.lputouch.R
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.lputouch.ui.theme.Nunito

@Composable
fun KeyPadSection(navController : NavController) {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .height(2.dp)
            .background(Color(0xF0F1F1F1)))
        LazyVerticalGrid(
            modifier = Modifier.fillMaxWidth(),
            columns = GridCells.Fixed(3)
        ) {
            items(
                listOf<String>(
                    "1",
                    "2",
                    "3",
                    "4",
                    "5",
                    "6",
                    "7",
                    "8",
                    "9",
                    "10",
                    "0",
                    "11"
                )
            ) { item ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(57.dp),
                    contentAlignment = Alignment.Center,

                    ) {
                    if (item == "10") {
                        Icon(
                            painterResource(R.drawable.backspace), contentDescription = null,
                            modifier = Modifier.size(36.dp)
                        )
                    } else if (item == "11") {
                        Icon(
                            painterResource(R.drawable.check_circle_24dp_1f1f1f),
                            contentDescription = null,
                            modifier = Modifier
                                .size(42.dp)
                                .clickable(onClick = {
                                    navController.navigate("main") {
                                        popUpTo("auth")
                                    }
                                }),
                            tint = Color(
                                0xFF1BDB78
                            )
                        )
                    } else {
                        Text(
                            item,
                            fontFamily = Nunito,
                            fontWeight = FontWeight.Normal,
                            fontSize = 24.sp,
                            modifier = Modifier
                                .clickable(onClick = {})
                                .padding(horizontal = 22.dp, vertical = 2.dp)
                                .clip(RoundedCornerShape(14.dp))
                        )
                    }

                }
            }
        }
    }

}