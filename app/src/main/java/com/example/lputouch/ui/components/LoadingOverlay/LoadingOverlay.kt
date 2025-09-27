package com.example.lputouch.ui.components.LoadingOverlay

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.lputouch.R
import kotlinx.coroutines.delay

@Composable
fun LoadingOverlay(isGeneral : Boolean) {
    var isLoading by remember { mutableStateOf(true) }


    LaunchedEffect(Unit) {
        if(!isGeneral) {
            delay(2000)
            isLoading = false
        }

    }


    if(isLoading){
        Box(modifier = Modifier.fillMaxSize().background(Color(0x74000000)).clickable(onClick = {}, indication = null, interactionSource = remember { MutableInteractionSource() } ),
            contentAlignment = Alignment.Center,
        ){
            CircularProgressIndicator(modifier = Modifier.size(67.dp), strokeWidth = 1.6.dp, color = Color(
                0xFFFD7E14
            )
            )
            Image(painterResource(R.drawable.logo), contentDescription = "null", modifier = Modifier.size(67.dp))
        }
    }

}