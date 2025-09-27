package com.example.lputouch.ui.features.main.screens.dashboard_screen.components.OptionsSection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lputouch.data.model.TileOption
import com.example.lputouch.data.source.TileOptionsList
import com.example.lputouch.ui.features.main.screens.dashboard_screen.components.OptionItem.OptionItem

@Composable
fun OptionsSection(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxWidth().padding(bottom = 18.dp),
        verticalArrangement = Arrangement.spacedBy(22.dp)
    ) {
        TileOptionsList.getTileOptionsList().chunked(3).forEach {
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 18.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                it.forEach {
                    OptionItem(it, navController)
                }

            }
        }

    }

}



















