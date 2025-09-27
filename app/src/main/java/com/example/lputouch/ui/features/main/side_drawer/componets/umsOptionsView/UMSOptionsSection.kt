package com.example.lputouch.ui.features.main.side_drawer.componets.umsOptionsView


import androidx.compose.foundation.BasicTooltipBox
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import com.example.lputouch.R
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lputouch.data.source.UMSOptionsList
import com.example.lputouch.ui.theme.Nunito
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun UMSOPtionsSection(
    modifier: Modifier = Modifier,
    navController: NavController,
    drawerState: DrawerState,
    keyboardController: SoftwareKeyboardController?
) {

    var scope = rememberCoroutineScope()
    var query = remember { mutableStateOf("") }
    var filteredList = remember(query.value) {
        if (query.value.isEmpty()) {
            UMSOptionsList.umsOptionsList
        } else {
            UMSOptionsList.umsOptionsList.filter {
                it.title.contains(
                    query.value,
                    ignoreCase = true
                )
            }
        }
    }

    Column(
        modifier = modifier.background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(12.dp)
                .background(Color.White)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFFEAEAEA))
                    .padding(horizontal = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painterResource(R.drawable.search), contentDescription = null,
                    tint = Color(0xFF676767),
                    modifier = Modifier.size(26.dp)
                )

                Spacer(modifier = Modifier.width(4.dp))

                BasicTextField(
                    value = query.value,
                    singleLine = true,
                    onValueChange = { value: String -> query.value = value },
                    modifier = Modifier.width(216.dp),
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = 16.4.sp,
                        fontFamily = Nunito,
                        fontWeight = FontWeight.Normal,
                    ),
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.Words
                    ),
                    decorationBox = { innerTextFeild ->
                        if (query.value.isEmpty()) {
                            Text(
                                "Search",
                                fontWeight = FontWeight.Normal,
                                fontFamily = Nunito,
                                fontSize = 16.4.sp,
                                color = Color(0xFF676767)
                            )
                        }
                        innerTextFeild()
                    }

                )

                if (query.value.isNotEmpty()) {
                    IconButton(
                        onClick = { query.value = "" },
                        modifier = Modifier.padding(horizontal = 0.dp)
                    ) {
                        Icon(
                            painterResource(R.drawable.cancel), contentDescription = null,
                            tint = Color(0xFF676767),
                            modifier = Modifier.size(19.dp)
                        )
                    }
                }


            }


        }

//        TextField(
//            value = query.value,
//            onValueChange = { value : String -> query.value = value },
//            modifier = Modifier.fillMaxWidth(),
//        )
//
        LazyColumn(
            modifier = Modifier.fillMaxWidth().background(Color(0xFFECECEC)),
            verticalArrangement = Arrangement.spacedBy(0.8.dp)
        ) {
            items(filteredList) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .clickable(onClick = {
                            keyboardController?.hide()
                            scope.launch {
                                drawerState.close()
                                delay(300)
                                val route = if (it.special == "residential") {
                                    "residential_screen"
                                } else {
                                    "general_screen/${it.title}"
                                }
                                navController.navigate(route)
                            }

                        },
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        )
                        .background(Color.White )
                        .padding(horizontal = 7.dp)


                    ,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(painterResource(it.icon), contentDescription = null, modifier = Modifier.size(26.dp))

                    Spacer(modifier = Modifier.width(25.dp))
                    Text(it.title, fontSize = 16.sp, fontWeight = FontWeight.Normal, color = Color(
                        0xFF5B5B5B
                    )
                    )
                }
            }
        }

    }

}