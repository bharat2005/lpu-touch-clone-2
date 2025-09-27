package com.example.lputouch.ui.features.mess.mess_screen.components.SuccessBottomSheet

import android.graphics.Paint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lputouch.AppViewModal
import com.example.lputouch.data.local.getMyDetails
import com.example.lputouch.ui.theme.Nunito
import kotlinx.coroutines.delay
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign

import com.example.lputouch.R
import com.example.lputouch.data.source.MessDetailList
import com.example.lputouch.ui.components.MyVideoPlayer
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlin.random.Random

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@ExperimentalMaterial3Api
fun SuccessBottomSheet(
    viewModal: AppViewModal,
    showSheet: MutableState<Boolean>,
    sheetState: SheetState
) {
    var scope = rememberCoroutineScope()


    var countDown by remember { mutableStateOf(30) }

    var context = LocalContext.current

    val savedData = getMyDetails(context, "mess_code")
    val mySavedData by savedData.collectAsState(initial = "")


    val hostelsavedData = getMyDetails(context, "hostel")
    val myHostelSavedData by hostelsavedData.collectAsState(initial = "")

    var loadImage by remember { mutableStateOf(false) }


    LaunchedEffect(Unit) {
        if (viewModal.messId != "null") {
            scope.launch {
                delay(2000)

                showSheet.value = true
                delay(300)
                sheetState.expand()

            }
        }
    }


    LaunchedEffect(showSheet.value) {
        if (showSheet.value) {

            scope.launch {
                delay(4000)
                loadImage = true

            }
        }}

    LaunchedEffect(showSheet.value) {
        if (showSheet.value) {
            while (countDown >= 0) {
                delay(1000)
                countDown--
            }
            sheetState.hide()
            delay(100)
            showSheet.value = false
            viewModal.resetMessId()
        }
    }

    fun generateRandomCode(): String {
        val prefix = "12"
        val allowChars = "123456789"
        val rnadomeCode = (1..6).map {
            allowChars.random()
        }.joinToString("")
        return rnadomeCode
    }



    if (showSheet.value) {
        var now = LocalDateTime.now()
        var nowDate = now.format(DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.ENGLISH))
        var nowTime = now.format(DateTimeFormatter.ofPattern("hh:mm a", Locale.ENGLISH))

        val myRadomeCode = remember {generateRandomCode() }


        ModalBottomSheet(
            sheetState = sheetState,
            containerColor = Color.White,
            onDismissRequest = {
                showSheet.value = false
                viewModal.resetMessId()
            },
            shape = RectangleShape,
            dragHandle = { SuccessDrawerHandle() }
        ) {

            val systemUiController = rememberSystemUiController()

            LaunchedEffect(Unit) {
                systemUiController.setSystemBarsColor(
                    color = Color(0xFF323232),
                    darkIcons = false
                )

                systemUiController.setNavigationBarColor(
                    color = Color.White
                )
            }




            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .background(Color(0xFF323232)),
                horizontalArrangement = Arrangement.SpaceBetween,
            )
            {

                Icon(
                    painterResource(R.drawable.close),
                    contentDescription = null,
                    tint = Color(0xFF323232),
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .size(21.dp)
                )


                Text(
                    "Mess Pass",
                    color = Color.White,
                    fontSize = 17.sp,
                    fontFamily = Nunito,
                    fontWeight = FontWeight.Medium
                )


                Icon(
                    painterResource(R.drawable.close),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .size(21.dp)
                        .clickable(onClick = {
                            scope.launch {
                                sheetState.hide()
                                delay(100)
                                showSheet.value = false
                                viewModal.resetMessId()
                            }
                        })
                )


            }



            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(790.dp)
                    .padding(horizontal = 12.dp)
            ) {
                item {
                    Spacer(Modifier.height(10.dp))
                }



                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .shadow(3.dp, RoundedCornerShape(18.dp), clip = true)
                            .clip(RoundedCornerShape(20.dp))

                    )
                    {
                        Column(
                            modifier = Modifier.fillMaxWidth()
                        )
                        {

                            //countdown row
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 8.dp)
                                    .padding(top = 8.dp),
                                horizontalArrangement = Arrangement.End
                            )
                            {
                                Box(
                                    modifier = Modifier
                                        .height(40.dp)
                                        .width(46.dp)
                                        .clip(RoundedCornerShape(18.dp))
                                        .background(Color(0xFFA6A6A6)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "$countDown",
                                        fontFamily = Nunito,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        style = TextStyle(
                                            color = Color.Black,
                                            fontSize = 40.sp,
                                            shadow = Shadow(
                                                color = Color.White,
                                                offset = Offset(x = 2f, y = 2f),
                                                blurRadius = 5f
                                            )
                                        )

                                    )
                                }
                            }


                            //imageName row
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 18.dp),
                            )
                            {
                                Box(
                                    modifier = Modifier
                                        .size(144.dp)
                                        .shadow(18.dp, CircleShape)
                                        .clip(CircleShape)
                                        .background(Color.Black),
                                    contentAlignment = Alignment.Center
                                ) {
                                    if (loadImage) {
                                        Image(
                                            painterResource(R.drawable.me),
                                            contentDescription = null,
                                            contentScale = ContentScale.Crop,
                                            modifier = Modifier
                                                .size(143.dp)
                                                .clip(CircleShape)
                                        )

                                    } else {
                                        Box(
                                            modifier = Modifier
                                                .size(143.dp)
                                                .clip(CircleShape)
                                                .background(Color.White)
                                        )


                                    }


                                }

                                Column(
                                    modifier = Modifier.padding(horizontal = 20.dp),
                                    verticalArrangement = Arrangement.spacedBy(4.dp)
                                )
                                {
                                    Text(
                                        "${viewModal.messId}",
                                        fontFamily = Nunito,
                                        fontSize = 29.sp,
                                        fontWeight = FontWeight.Bold,
                                        style = TextStyle(
                                            color = Color.Black,
                                            shadow = Shadow(
                                                color = Color(0x65000000),
                                                offset = Offset(2f, 2f),
                                                blurRadius = 2f
                                            )
                                        )
                                    )
                                    Spacer(modifier = Modifier.height(1.dp))
                                    Text(
                                        "12413923",
                                        fontFamily = Nunito,
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold,
                                        style = TextStyle(
                                            color = Color.Black,
                                            shadow = Shadow(
                                                color = Color(0x65000000),
                                                offset = Offset(2f, 2f),
                                                blurRadius = 2f
                                            )
                                        )
                                    )
                                    Text(
                                        "Deshmukh Bharat Vasanta",
                                        fontFamily = Nunito,
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold,
                                        style = TextStyle(
                                            color = Color.Black,
                                            shadow = Shadow(
                                                color = Color(0x65000000),
                                                offset = Offset(2f, 2f),
                                                blurRadius = 2f
                                            )
                                        )
                                    )
                                    Text(
                                        "$mySavedData",
                                        fontFamily = Nunito,
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold,
                                        style = TextStyle(
                                            color = Color.Black,
                                            shadow = Shadow(
                                                color = Color(0x65000000),
                                                offset = Offset(2f, 2f),
                                                blurRadius = 2f
                                            )
                                        )
                                    )

                                }

                            }


                            //coursetext
                            Text(
                                "P132:B.Tech. (Computer Science and Engineering)(2024)",
                                fontSize = 16.sp,
                                fontFamily = Nunito,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier
                                    .padding(vertical = 24.dp)
                                    .padding(horizontal = 18.dp)
                            )


                            //Twoblobs
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 10.dp)
                            )
                            {
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 34.dp)
                                ) {
                                    Text(
                                        "$nowDate",
                                        fontFamily = Nunito,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold
                                    )

                                }
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 34.dp)
                                ) {
                                    Text(
                                        "$nowTime",
                                        fontFamily = Nunito,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold
                                    )

                                }


                            }


                            //AnimationPart
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 24.dp)
                            )
                            {
                                Text(
                                    "Meal Approved",
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    fontFamily = Nunito,
                                    fontSize = 27.sp,
                                    fontWeight = FontWeight.Bold,
                                    style = TextStyle(
                                        color = Color(0xFF59BF1A),
                                        shadow = Shadow(
                                            color = Color(0xCD5ABD1C),
                                            offset = Offset(3f, 3f),
                                            blurRadius = 3f
                                        )
                                    )
                                )

                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .aspectRatio(1f)
                                        .padding(horizontal = 2.dp)
                                        .background(
                                            Color(0xFF246900)
                                        )
                                        .padding(22.dp),
                                    contentAlignment = Alignment.Center
                                )
                                {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .background(Color.White)
                                            .clip(RectangleShape),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        MyVideoPlayer(modifier = Modifier
                                            .fillMaxSize()
                                            .scale(1f))

                                    }

                                }
                            }

                            //SuccessScreen Details
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .shadow(2.dp, RoundedCornerShape(6.dp), clip = true)
                                    .clip(RoundedCornerShape(6.dp))
                                    .padding(horizontal = 6.dp)
                                    .background(Color.White),
                            )
                            {

                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 8.dp, vertical = 12.dp)
                                        .padding(top = 14.dp, bottom = 8.dp),
                                    verticalArrangement = Arrangement.spacedBy(8.dp)
                                )
                                {
                                    MessDetailList.getSuccessMessDetilsList().forEach { item ->
                                        Column(
                                            modifier = Modifier.fillMaxWidth()
                                        ) {
                                            Text(
                                                item.key,
                                                fontFamily = Nunito,
                                                fontSize = 14.sp,
                                                lineHeight = 18.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color(0xFF656565)
                                            )
                                            Spacer(modifier = Modifier.height(4.dp))
                                            Text(
                                                if (item.value == "null") "$myHostelSavedData" else item.value,
                                                fontFamily = Nunito,
                                                fontSize = 14.sp,
                                                lineHeight = 16.sp,
                                                fontWeight = FontWeight.Normal,
                                                color = Color(0xFF656565)
                                            )

                                        }


                                    }

                                }
                            }



                            Spacer(Modifier
                                .fillMaxWidth()
                                .height(28.dp))


                            Box(
                                modifier = Modifier.fillMaxWidth().height(54.dp )
                                    .padding(3.dp)
                                    .border(1.4.dp, Color.Black, RoundedCornerShape(10.dp))
                            )
                            {
                                Row(
                                    modifier = Modifier.fillMaxSize(),
                                    verticalAlignment = Alignment.CenterVertically
                                ){
                                    Spacer(modifier = Modifier.width(8.dp ))
                                    Text(
                                        "Verification Code",
                                        fontFamily = Nunito ,
                                        fontSize = 19.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.weight(1f),
                                        textAlign = TextAlign.Center

                                    )

                                    Text(
                                        "12${myRadomeCode}",
                                        fontFamily = Nunito ,
                                        fontSize = 19.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.weight(1f),
                                        textAlign = TextAlign.Center

                                    )

                                }
                            }

                            Spacer(modifier = Modifier.height(8.dp))



                        }

                    }

                    Spacer(Modifier
                        .fillMaxWidth()
                        .height(18.dp))


                }

            }

        }
    }


}
