package com.example.lputouch.ui.features.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.lputouch.data.model.SettingFeild
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.lputouch.data.local.getMyDetails
import com.example.lputouch.data.local.saveMyDetails
import kotlinx.coroutines.launch

@Composable
fun FeildItem(feildData : SettingFeild) {
    var text by remember { mutableStateOf("") }
    var context = LocalContext.current
    val scope = rememberCoroutineScope()

    val savedData = getMyDetails(context, feildData.name)
    val mySavedData by savedData.collectAsState(initial = "")

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("${feildData.title}")
        Text("${feildData.example}")

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            placeholder = {Text("$mySavedData")}
        )

        Button(onClick = {
            scope.launch {
                saveMyDetails(context, feildData.name, text)
            }
        }) {
            Text("SAVE")
        }
        Spacer(modifier = Modifier.height(50.dp))

    }

}