package com.example.lputouch.ui.features.auth.components

import androidx.annotation.ColorRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lputouch.ui.theme.Nunito

@Composable
fun TextPinView(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(vertical = 30.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),

    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Text("Enter your LPUTocuh PIN", modifier = Modifier.weight(1f), fontSize = 20.sp, fontFamily = Nunito, fontWeight = FontWeight.Normal, textAlign = TextAlign.Center)
            Box(
                modifier = Modifier.background(Color.Red, RoundedCornerShape(8.dp)).padding(horizontal = 4.dp)
                    .clickable(onClick = {}, indication = null, interactionSource = remember{ MutableInteractionSource() })
                ,
                contentAlignment = androidx.compose.ui.Alignment.Center
            ){
                Text("Reset Pin", color = Color.White, fontSize = 11.5.sp, fontFamily = Nunito, fontWeight = FontWeight.Bold)
            }

        }

        Text("Please enter your secure PIN to access your application.", fontSize = 12.5.sp, fontFamily = Nunito, fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(horizontal = 18.dp))



        LazyRow(
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp, alignment = Alignment.CenterHorizontally)
        ) {
            items(6){
                item ->
                Box(modifier = Modifier.size(46.dp).border(width = 1.5.dp, color = Color.Black, shape = RoundedCornerShape(9.dp)))
            }
        }
    }

}













