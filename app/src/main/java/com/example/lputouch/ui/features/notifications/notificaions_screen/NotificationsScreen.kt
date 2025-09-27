package com.example.lputouch.ui.features.notifications.notificaions_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import com.example.lputouch.R
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.lputouch.data.source.MyMessagesList
import com.example.lputouch.ui.components.generalTopBar.GeneralTopbar
import com.example.lputouch.ui.features.notifications.notificaions_screen.components.MyMessageBox.MyMessageBox
import com.example.lputouch.ui.theme.Nunito

@ExperimentalMaterial3Api
@Composable
fun NotificationsScreen(navController: NavController) {
    Scaffold(
        topBar = { GeneralTopbar(navController, title = "My Messages",  true) },
    ){
        paddingValues ->

        Column(
            modifier = Modifier.padding(paddingValues).fillMaxSize().background(Color.White)
        ) {

            Box(
                modifier = Modifier.fillMaxWidth().height(60.dp).shadow(0.dp).padding(6.dp).background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier.fillMaxSize().shadow(2.dp),
                ){

                    Row(
                        modifier = Modifier.fillMaxSize().padding(horizontal = 18.dp, vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {

                        Icon(painterResource(R.drawable.search),
                            contentDescription = null,
                            tint = Color(0xFF424242)

                            )

                        Text(
                            "Search",
                            fontFamily = Nunito,
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                            color = Color(0xFF626262)
                        )

                    }


                }


            }


            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(horizontal = 12.dp)
                    .padding(top = 16.dp)

            ) {
                items(MyMessagesList.getMyMessagesList()) { messageItem ->
                    MyMessageBox(messageItem)
                }


            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
@Preview(showSystemUi = true)
fun MyPreivew(){
    NotificationsScreen(navController = rememberNavController())

}