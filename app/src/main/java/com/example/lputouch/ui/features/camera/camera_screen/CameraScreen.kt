package com.example.lputouch.ui.features.camera.camera_screen

import android.media.MediaPlayer
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.lputouch.R
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.lputouch.ui.features.camera.camera_screen.components.CameraOverlay.CameraOverlay
import com.example.lputouch.ui.features.camera.camera_screen.components.CameraView.CameraView
import com.example.lputouch.ui.features.camera.camera_screen.components.CameraView.CameraView
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.example.lputouch.AppViewModal
import com.google.accompanist.permissions.rememberPermissionState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
@ExperimentalPermissionsApi
fun CameraScreen(navController: NavController, food : String, viewModal: AppViewModal) {
    var currentLineOffset by remember { mutableStateOf(0f) }
    var isScanned by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    val cameraPermissionRequest = rememberPermissionState(
        android.Manifest.permission.CAMERA
    )

    LaunchedEffect(Unit) {
        if(!cameraPermissionRequest.status.isGranted){
            cameraPermissionRequest.launchPermissionRequest()
        }
    }

//    LaunchedEffect(isScanned) {
//        if(isScanned){
//            val mediaPayer = MediaPlayer.create(context, R.raw.beep)
//            mediaPayer.setOnCompletionListener {
//                mediaPayer.release()
//            }
//            mediaPayer.start()
//        }
//    }



        if (cameraPermissionRequest.status.isGranted) {
            Box(
                modifier = Modifier.fillMaxSize().background(Color.Black).clickable(
                    indication = null, interactionSource = remember { MutableInteractionSource() },
                    onClick = {
                        scope.launch {
                            delay(2000)
                            isScanned = true
                            viewModal.upDateMessId(food)
                            delay(2800)
                            navController.navigateUp()
                        }
                    })
            ) {
                CameraView()

                CameraOverlay(
                    isScanned = isScanned,
                    onLineOffsetChange = { currentLineOffset = it },
                    currentLineOffset = currentLineOffset
                )
            }

        } else {
            Column(
                modifier = Modifier.fillMaxSize().background(Color.Black),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Camera Permision is required")
                Button(onClick = { cameraPermissionRequest.launchPermissionRequest() }) {
                    Text("Request Permission")
                }
            }
        }


}


