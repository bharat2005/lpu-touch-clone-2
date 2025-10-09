package com.example.lputouch.ui.components

import android.net.Uri
import androidx.camera.core.AspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.Lifecycle
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.example.lputouch.R
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.ui.PlayerView

@Composable
fun MyVideoPlayer(modifier: Modifier = Modifier, exoPlayer : ExoPlayer) {
    val context = LocalContext.current
    val lifeCycleOwner = LocalLifecycleOwner.current





        DisposableEffect(lifeCycleOwner) {
            val observer = LifecycleEventObserver {_, event ->
                when (event){
                    Lifecycle.Event.ON_PAUSE -> {
                        exoPlayer.pause()
                    }
                    Lifecycle.Event.ON_RESUME -> {
                        exoPlayer.play()
                    }
                    else -> {}
                }
            }

            lifeCycleOwner.lifecycle.addObserver(observer)

            onDispose {
                exoPlayer.release()
                lifeCycleOwner.lifecycle.removeObserver(observer)
            }

        }


    AndroidView(
        factory = {
            ctx ->
            PlayerView(ctx).apply {
                player = exoPlayer
                useController = false
              //  resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
            }
        },
        modifier = modifier
    )

}