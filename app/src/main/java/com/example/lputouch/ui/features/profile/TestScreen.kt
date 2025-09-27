package com.example.lputouch.ui.features.profile
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestScreen() {
    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false
    )

    var showSheet by remember { mutableStateOf(false) }

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = { showSheet = true }) {
            Text("Open Bottom Sheet")
        }
    }

    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = { showSheet = false },
            sheetState = sheetState
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .height(800.dp) // optional fixed height
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Fully Expanded Bottom Sheet")
                Spacer(Modifier.height(8.dp))
                Button(onClick = {
                    scope.launch {
                        // Animate to fully expanded
                        sheetState.expand()
                    }
                }) {
                    Text("Expand Fully")
                }
                Spacer(Modifier.height(8.dp))
                Button(onClick = { showSheet = false }) {
                    Text("Close")
                }
            }
        }
    }
}

