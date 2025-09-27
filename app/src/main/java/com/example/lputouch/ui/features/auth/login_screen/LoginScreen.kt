package com.example.lputouch.ui.features.auth.login_screen

import android.os.Build
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.annotation.RequiresApi
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import com.example.lputouch.R
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.lputouch.AppViewModal
import com.example.lputouch.authentication.BiometricAuth
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.ModifierLocalReadScope
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.lputouch.ui.features.auth.components.KeyPadSection
import com.example.lputouch.ui.features.auth.components.TextPinView
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay


@Composable
fun LoginScreen(navController: NavHostController, viewModal: AppViewModal) {
    val activity = LocalContext.current as FragmentActivity
    var isLoading by remember { mutableStateOf(true) }


    LaunchedEffect(Unit) {
        delay(2500)
        isLoading = false
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
    } else {

        LaunchedEffect(Unit) {
            BiometricAuth.authenticate(
                activity,
                onSuccess = {
                    navController.navigate("main") {
                        popUpTo("auth")
                    }
                },
                onError = {},
                title = "Fingerprint Authentication",
            )
        }

        Scaffold { paddingValues ->
            Column(
                modifier = Modifier.fillMaxSize().padding(paddingValues).background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                TextPinView()

                KeyPadSection(navController)

            }
        }
    }}

