package com.example.danp_proyecto

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Button
import androidx.compose.material.Slider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.danp_proyecto.Navegacion.BarraNavegacion

@Composable
fun InicioScreen(navController: NavHostController, sensorvm: ViewModel) {
    var color1 = remember {
        mutableStateOf(Color.White)
    }
    var color2 = remember {
        mutableStateOf(Color.White)
    }

    val datos: List<String> = sensorvm.dataList

    var sliderValue by remember { mutableStateOf(0f) }

    Scaffold(
        bottomBar = {
            BarraNavegacion(navController = navController)
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color(0xFFb694e1), Color(0xFFE084AD)),
                            startY = 0f,
                            endY = Float.POSITIVE_INFINITY
                        )
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            )
            {
                Surface(
                    modifier = Modifier
                        .width(180.dp)
                        .height(180.dp)
                        .clip(RoundedCornerShape(100.dp))
                        .align(Alignment.CenterHorizontally),
                    color = Color(0x39FFFFFF)
                )
                {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    )
                    {
                        Text(
                            text = "Sensor de Luz",
                            style = TextStyle(fontSize = 24.sp, color = Color.White),
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .height(48.dp)
                                .wrapContentSize(Alignment.Center)
                                .padding(8.dp),
                        )
                        Row() {
                            Button(
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = color1.value,
                                    contentColor = Color.Black
                                ),
                                onClick = {
                                    color1.value = Color.LightGray
                                    color2.value = Color.White
                                    sensorvm.publishMessage("inTopic", "1")
                                }) {
                                androidx.compose.material.Text(text = "ON")
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Button(
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = color2.value,
                                    contentColor = Color.Black
                                ),
                                onClick = {
                                    color1.value = Color.White
                                    color2.value = Color.LightGray
                                    sensorvm.publishMessage("inTopic", "0")
                                }) {
                                Text(text = "OFF")
                            }
                        }
                    }

                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Slider(
                        value = sliderValue,
                        onValueChange = { newValue ->
                            sliderValue = newValue
                        },
                        valueRange = 0f..100f,
                        steps = 1
                    )
                    Text(
                        text = "Value: ${sliderValue.toInt()}",
                        color = Color.Black
                        )
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = color2.value,
                            contentColor = Color.Black
                        ),
                        onClick = {
                            sensorvm.publishMessage("inTopic", sliderValue.toString())
                        }) {
                        Text(text = "Establecer")
                    }

                }

            }

        }
    )
}