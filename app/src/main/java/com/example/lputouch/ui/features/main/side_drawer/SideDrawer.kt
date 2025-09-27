package com.example.lputouch.ui.features.main.side_drawer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lputouch.ui.features.main.side_drawer.componets.drawerProfileView.DrawerProfileSection
import com.example.lputouch.ui.features.main.side_drawer.componets.logoutButtonSection.LogoutButtonSection
import com.example.lputouch.ui.features.main.side_drawer.componets.umsOptionsView.UMSOPtionsSection

@Composable
fun SideDrawer(navController: NavController, drawerState: DrawerState, focusManger : FocusManager, keyboardController: SoftwareKeyboardController?) {



    ModalDrawerSheet(
        modifier = Modifier.fillMaxWidth(0.72f).background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clickable(indication = null, interactionSource = remember { MutableInteractionSource() }){
                    focusManger.clearFocus()
                }.background(Color.White)
        ) {

            DrawerProfileSection(navController, drawerState)

            UMSOPtionsSection(modifier = Modifier.fillMaxWidth().weight(1f), navController, drawerState, keyboardController)

            LogoutButtonSection()



        }

    }

}


@Preview(showSystemUi = true)
@Composable
fun MyPreview(){
    SideDrawer(navController = rememberNavController(), drawerState = rememberDrawerState(initialValue = DrawerValue.Closed), focusManger = LocalFocusManager.current, keyboardController = LocalSoftwareKeyboardController.current)
}