package com.example.lputouch.authentication

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity

object BiometricAuth {
    fun authenticate(
        activity: FragmentActivity,
        onSuccess: () -> Unit,
        onError: () -> Unit,
        title: String,
    ) {
        val executor = ContextCompat.getMainExecutor(activity)
        val promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle(title)
            .setNegativeButtonText("Cancel")
            .build()

        val biometricPrompt =
            BiometricPrompt(activity, executor,
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult?) {
                    onSuccess()
                }

                override fun onAuthenticationFailed() {
                    onError()
                }

                override fun onAuthenticationError(errorCode: Int, errString: CharSequence?) {
                    onError()
                }
            }
            ).authenticate(promptInfo)


    }
}

