package com.example.lputouch.ui.features.mess.mess_screen.components.SuccessBottomSheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SuccessDrawerHandle(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxWidth().background(Color(0xFF323232)).padding(vertical = 6.dp),
        contentAlignment = Alignment.Center
    ){
        Box(modifier = Modifier.width(36.dp).height(5.dp).clip(RoundedCornerShape(18.dp)).background(Color.LightGray))
    }

}