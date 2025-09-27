package com.example.lputouch.ui.features.notifications.notificaions_screen.components.MyMessageBox

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lputouch.data.model.MyMessage
import com.example.lputouch.ui.theme.Nunito
import kotlin.math.exp

@Composable
fun MyMessageBox(messageItem: MyMessage, modifier: Modifier = Modifier) {
    var expanded = remember { mutableStateOf(false) }

    Surface(
        shadowElevation = 4.dp,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(4.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(
                    onClick = { expanded.value = !expanded.value },
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() })
                .background(Color.White)
                .padding(vertical = 12.dp, horizontal = 14.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                messageItem.title,
                fontWeight = FontWeight.Bold,
                fontFamily = Nunito,
                fontSize = 14.sp,
                color = Color(0xFF676767),
            )
            Text(
                messageItem.text,
                maxLines = if (expanded.value) 100 else 2,
                overflow = TextOverflow.Ellipsis,
                fontSize = 14.sp,
                lineHeight = 18.sp,
                fontFamily = Nunito,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF7C7C7C),

                )
            Text(
                messageItem.byName,
                fontFamily = Nunito,
                fontWeight = FontWeight.Normal,
                color = Color(0xFFFD7E14),
                fontSize = 14.sp
            )

        }
    }
    Spacer(modifier = Modifier.height(12.dp))
}