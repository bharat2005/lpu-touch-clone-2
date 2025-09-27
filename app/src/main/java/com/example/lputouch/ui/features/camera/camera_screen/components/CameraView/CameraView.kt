package com.example.lputouch.ui.features.camera.camera_screen.components.CameraView

import android.util.Log
import androidx.camera.core.CameraSelector
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat


@Composable
fun CameraView(modifier: Modifier = Modifier) {
    val lifeCycleOwner = LocalLifecycleOwner.current

    AndroidView(
        modifier = Modifier.fillMaxSize().background(Color.Black),
        factory = { ctx ->
            val previewView = PreviewView(ctx).apply {
                setBackgroundColor(android.graphics.Color.BLACK)
                scaleType = PreviewView.ScaleType.FILL_CENTER

            }

            val cameraProviderFuture = ProcessCameraProvider.getInstance(ctx)

            cameraProviderFuture.addListener({
                val cameraProvider = cameraProviderFuture.get()

                val preview = androidx.camera.core.Preview.Builder().build().also {
                    it.setSurfaceProvider(previewView.surfaceProvider)
                }

                try{
                    cameraProvider.unbindAll()
                    cameraProvider.bindToLifecycle(
                        lifeCycleOwner,
                        CameraSelector.DEFAULT_BACK_CAMERA,
                        preview
                    )
                } catch (exc : Exception){
                    //error
                }
            }, ContextCompat.getMainExecutor(ctx ))

            previewView

        }
    )

}