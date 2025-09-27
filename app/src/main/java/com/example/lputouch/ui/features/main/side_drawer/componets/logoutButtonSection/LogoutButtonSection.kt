package com.example.lputouch.ui.features.main.side_drawer.componets.logoutButtonSection

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lputouch.ui.theme.Nunito
import com.example.lputouch.R

@Composable
fun LogoutButtonSection(modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxWidth().height(0.8.dp).background(Color(0xFFD9D9D9)))
    Box(
        modifier = Modifier.fillMaxWidth().height(60.dp).padding(horizontal = 8.dp, vertical = 12.dp),
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .shadow(2.dp, RoundedCornerShape(18.dp))
                .clip(RoundedCornerShape(18.dp))
                .background(brush =
                    Brush.horizontalGradient(colors =
                    listOf(
                        Color(0xFFFF8278),
                        Color(0xFFFCCC6A)
                    )))
                .clickable(onClick = {})
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text("LOGOUT", fontFamily = Nunito, fontSize = 14.sp, fontWeight = FontWeight.Medium, )
                Spacer(modifier = Modifier.width(12.dp))
                Icon(painterResource(R.drawable.move_item_24dp_1f1f1f_fill0_wght400_grad0_opsz24), contentDescription = null, modifier = Modifier.size(15.dp))

            }

        }
    }
}