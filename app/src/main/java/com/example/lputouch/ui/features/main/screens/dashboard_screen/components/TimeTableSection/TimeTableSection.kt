package com.example.lputouch.ui.features.main.screens.dashboard_screen.components.TimeTableSection

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.TextToolbar
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lputouch.ui.theme.Nunito

@Composable
fun TimeTableSection() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(top = 2.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 18.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Today's Timetable", fontSize = 20.sp, fontFamily = Nunito, fontWeight = FontWeight.Normal)


            Box(
                modifier = Modifier.background(brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFFFF7C6B),
                        Color(0xFFFCCC6A)
                )),
                    shape = RoundedCornerShape(6.dp)
                )

            ){
                Text("Your Dost", fontFamily = Nunito, fontSize = 16.sp, fontWeight = FontWeight.Normal, modifier = Modifier.padding(horizontal = 6.dp))
            }
        }


//        LazyRow(
//            modifier = Modifier.fillMaxWidth().padding(horizontal = 18.dp),
//            horizontalArrangement = Arrangement.spacedBy(12.dp)
//        ) {
//            items(4){
//                Surface(modifier = Modifier.height(120.dp).width(180.dp), color = Color.Red) {  }
//            }
//        }

        Box(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 18.dp),
        ){
            Box(
                modifier = Modifier.fillMaxWidth().height(100.dp).border(0.4.dp, Color.LightGray, RoundedCornerShape(6.dp)),
                contentAlignment = Alignment.Center
            )
            {
                Text("No TimeTable Available", fontSize = 22.sp, fontFamily = Nunito, fontWeight = FontWeight.Medium, color = Color.Gray)
            }
        }


        Row(
            modifier = Modifier.padding(horizontal = 18.dp).padding(top = 12.dp, bottom = 8.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text("Add More Tiles", fontWeight = FontWeight.Normal, fontSize = 20.sp, fontFamily = Nunito)
                Text("Click on the plus button to add menu grids.", fontWeight = FontWeight.Normal, fontSize = 14.sp, fontFamily = Nunito)
            }

            Icon(Icons.Default.AddCircle, contentDescription = null, modifier = Modifier.size(30.dp))

        }

    }

}