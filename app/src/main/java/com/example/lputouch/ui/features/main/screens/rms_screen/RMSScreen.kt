package com.example.lputouch.ui.features.main.screens.rms_screen

import androidx.annotation.ColorRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lputouch.data.source.RMSConditionsList
import com.example.lputouch.ui.components.LoadingOverlay.LoadingOverlay
import com.example.lputouch.ui.theme.Nunito

@Composable
fun RMSScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 24.dp)
            .padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(4.dp, RoundedCornerShape(4.dp))
                .clip(RoundedCornerShape(4.dp))
                .background(Color.White),
        ) {

            Column(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 18.dp, vertical = 18.dp)
            ) {

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    RMSConditionsList.getRMSConditionsList().forEach { item ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Checkbox(
                                modifier = Modifier.scale(0.9f),
                                onCheckedChange = null,
                                checked = true,
                                colors = CheckboxDefaults.colors(
                                    checkedColor = Color(0xFFFFE2C9),

                                    ),
                            )

                            Text(
                                item.condition,
                                fontSize = 14.sp,
                                fontFamily = Nunito,
                                fontWeight = FontWeight.Normal,
                                color = Color(0xF03A3A3A),
                                lineHeight = 20.sp
                            )
                        }
                    }

                }

                Spacer(modifier = Modifier.height(16.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {

                    Box(
                        modifier = Modifier
                            .shadow(6.dp, RoundedCornerShape(6.dp))
                            .background(
                                brush = Brush.horizontalGradient(
                                    colors = listOf(
                                        Color(0xFFFF7C6B),
                                        Color(0xFFFCCC6A)
                                    )
                                )
                            ),
                    ) {
                        Text(
                            "Agree & Proceed",
                            fontFamily = Nunito,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.padding(horizontal = 18.dp, vertical = 8.dp),

                        )
                    }

                }
            }


        }
    }


}