package com.example.lputouch.ui.features.camera.camera_screen.components.CameraOverlay

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.example.lputouch.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Canvas
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lputouch.data.local.getMyDetails
import kotlinx.coroutines.delay


@Composable
fun CameraOverlay(
    isScanned: Boolean,
    onLineOffsetChange: (Float) -> Unit,
    currentLineOffset: Float
) {

    var context = LocalContext.current

    val savedData = getMyDetails(context, "plaintext")
    val mySavedData by savedData.collectAsState(initial = "")



    Box(modifier = Modifier.fillMaxSize()) {

        Canvas(modifier = Modifier.fillMaxSize()) {

            val width = size.width
            val height = size.height

            val rectWidth = 0.63f * width
            val rectHeight = 0.94f * width
            
            val top = (height - rectHeight) / 2
            val left = (width - rectWidth) / 2

            drawRect(color = if (isScanned)
                Color(0xA6000000)
            else Color(0x59000000), size = size)


                drawRect(
                    color = Color.Transparent,
                    blendMode = BlendMode.Clear,
                    size = Size(rectWidth, rectHeight),
                    topLeft = Offset(left, top)
                )
            


        }
        if(!isScanned) {

            val infiniteTransition = rememberInfiniteTransition()

            val blink = infiniteTransition.animateFloat(
                initialValue = 0f,
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis = 400, easing = LinearEasing),
                    repeatMode = RepeatMode.Reverse
                )
            )



            Canvas(modifier = Modifier.fillMaxSize()) {
                val width = size.width
                val height = size.height

                val rectWidth = 0.65f * width
                val rectHeight = 0.9f * width

                val top = (height - rectHeight) / 2
                val left = (width - rectWidth) / 2

                val centerY = top + (rectHeight / 2)

                drawLine(
                    start = Offset(left, centerY),
                    end = Offset(left + rectWidth, centerY),
                    strokeWidth = 2.8f,
                    color = Color.Red.copy(alpha = blink.value)
                )

            }

        }

        Text(
            if (isScanned) "Found plain text: $mySavedData" else "Place a barcode inside the viewfinder rectangle to scan it.",
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(vertical = 42.dp)
        )



    }

    }



@Preview(showSystemUi = true)
@Composable
fun MyPreview() {
    CameraOverlay(true, { 1 }, 1f)
}
























