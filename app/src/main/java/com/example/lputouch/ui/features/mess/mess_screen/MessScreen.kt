package com.example.lputouch.ui.features.mess.mess_screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lputouch.AppViewModal
import com.example.lputouch.R
import com.example.lputouch.data.local.getMyDetails
import com.example.lputouch.data.local.getMyMessColor
import com.example.lputouch.data.source.MessDetailList
import com.example.lputouch.ui.components.LoadingOverlay.LoadingOverlay
import com.example.lputouch.ui.features.mess.mess_screen.components.SuccessBottomSheet.SuccessBottomSheet
import com.example.lputouch.ui.features.mess.mess_screen.components.messTopBar.MessTopBar
import com.example.lputouch.ui.theme.FourLeaf
import com.example.lputouch.ui.theme.Nunito
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@ExperimentalMaterial3Api
@Composable
fun MessScreen(navController: NavController, viewModal: AppViewModal) {
    var context = LocalContext.current

    val savedData = getMyDetails(context, "hostel")
    val mySavedData by savedData.collectAsState(initial = "")


    var showSheet = remember { mutableStateOf(false) }
    var sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    var scope = rememberCoroutineScope()

    val myStoredColor = getMyMessColor(context).collectAsState(FourLeaf).value


    Scaffold(
        topBar = { MessTopBar(navController) }
    ) { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(8.dp)
                .background(Color.White)
        ) {

            Surface(
                modifier = Modifier
                    .fillMaxWidth().background(Color.White),
                shadowElevation = 2.dp
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth().background(Color.White)

                ) {


                    //prifile column
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(6.dp))
                            .background(
                                brush = Brush.horizontalGradient(
                                    listOf(
                                        Color(0xFFFF8278),
                                        Color(0xFFFCCC6A)
                                    )
                                )
                            )
                            .padding(vertical = 18.dp),
                        verticalArrangement = Arrangement.spacedBy(
                            2.dp,
                            alignment = Alignment.CenterVertically
                        ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painterResource(R.drawable.me),
                            contentScale = ContentScale.FillBounds,
                            contentDescription = null,
                            modifier = Modifier
                                .size(120.dp)
                                .clip(RoundedCornerShape(8.dp))
                        )
                        Text(
                            "Deshmukh Bharat Vasanta",
                            fontFamily = Nunito,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF343434)
                        )



                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 18.dp, vertical = 12.dp)
                                .padding(top = 6.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        )
                        {
                            MessDetailList.getMessDetilsList().forEach { item ->
                                Column(
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        item.key,
                                        fontFamily = Nunito,
                                        fontSize = 14.sp,
                                        lineHeight = 10.4.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFF343434)
                                    )
                                    Text(
                                        if (item.value=="null") "$mySavedData" else item.value,
                                        fontFamily = Nunito,
                                        fontSize = 14.sp,
                                        lineHeight = 18.4.sp,
                                        fontWeight = FontWeight.Normal,
                                        color = Color(0xFF2D2D2D)
                                    )

                                }


                            }

                        }
                    }


                    //button section

                    Text(
                        "Tap on the meal name to scan and avail food.",
                        fontFamily = Nunito,
                        fontSize = 23.sp,
                        lineHeight = 27.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 28.dp, vertical = 26.dp)
                            .padding(top = 8.dp),
                        textAlign = TextAlign.Center
                    )

                    Column (
                        modifier = Modifier
                            .fillMaxWidth().background(Color.White),
                        verticalArrangement = Arrangement.spacedBy(16.dp)

                    ) {
                        listOf("BreakFast", "Lunch", "Dinner").chunked(2).forEach {
                            item ->
                            Row(
                                modifier = Modifier.fillMaxWidth().padding(horizontal = 42.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                item.forEach {
                                    subItem ->

                                    Box(
                                        modifier = Modifier
                                            .width(154.dp)
                                            .height(54.dp)
                                            .shadow(4.dp, RoundedCornerShape(4.dp), ambientColor = Color.Black, spotColor = Color.Black)
                                            .clip(RoundedCornerShape(6.dp))
                                            .background(brush =
                                                Brush.horizontalGradient(listOf(
                                                    Color(0xFFFF8278),
                                                    Color(0xFFFCCC6A)
                                                )
                                                ))
                                            .clickable(onClick = {navController.navigate("camera_screen/${subItem}")
                                            }, indication = null, interactionSource = remember { MutableInteractionSource() }),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(2.dp, alignment = Alignment.CenterHorizontally)){
                                            Text(subItem,
                                                fontFamily = Nunito,
                                                fontSize = 16.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color(0xFF383838)
                                                )
                                            Icon(Icons.Default.ArrowForward, contentDescription = null, modifier = Modifier.size(14.dp))

                                        }

                                    }

                                }
                            }

                        }

                    }

                    Spacer(modifier = Modifier.height(52.dp))


                }
            }

        }




    SuccessBottomSheet(viewModal, showSheet, sheetState, myStoredColor )


    LoadingOverlay(isGeneral = false)


    }
}


