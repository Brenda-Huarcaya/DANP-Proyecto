package com.example.danp_proyecto.uis.screen_sensor

import com.example.danp_proyecto.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.danp_proyecto.Navegacion.BarraNavegacion
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.roundToInt


@Composable
fun SensorSliderScreen(navController: NavHostController, sensorViewModel: SensorDataViewModel) {

    var sliderValue by remember { mutableStateOf(0f) }
    //val datosSensor: List<LineData> = sensorViewModel.dataList
    //val alerta: String by sensorViewModel.datito.observeAsState("Sin datos")
    val datitoUltimoValue by sensorViewModel.datitoUltimo.observeAsState(0f)
    val alerta: String =
        if (datitoUltimoValue > 600) {
            "NORMAL"
        } else if (datitoUltimoValue >= 300 && datitoUltimoValue <= 600){
            "ALGUIEN ESTA FUMANDO"
        }
        else {
            "PELIGRO DE INCENDIO"
        }

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
                        color = Color(0xFF6379e6)
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            )
            {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = "Datos del sensor",
                        style = TextStyle(
                            fontSize = 25.sp,
                            color = Color(0xFFfb846f),
                            fontFamily = FontFamily(Font(R.font.luckiestguyregular))
                        ),
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .align(Alignment.CenterHorizontally),
                    )

                    Spacer(modifier = Modifier.height(50.dp))

                    Box(
                        modifier = Modifier
                            .size(200.dp)
                            .clip(RoundedCornerShape(100.dp))
                            .background(Color(0x80FFFFFF))
                    ) {
                        Box(
                            modifier = Modifier
                                .size(150.dp)
                                .clip(RoundedCornerShape(100.dp))
                                .background(color = Color.White)
                                .align(Alignment.Center)
                        ) {

                            Text(
                                text = "$datitoUltimoValue",
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .wrapContentSize(Alignment.Center),
                                style = TextStyle(
                                    fontSize = 50.sp,
                                    color = Color(0xFFfb846f),
                                    fontFamily = FontFamily(Font(R.font.luckiestguyregular))
                                ),
                            )
                        }

                    }

                    Spacer(modifier = Modifier.height(50.dp))
                    val messageAnterior = ""
                        Slider(
                            value = sliderValue,
                            onValueChange = { newValue ->
                                sliderValue = newValue
                                if (sliderValue.toInt() > 2 && sliderValue.toInt() % 10 ==0) {
                                    val roundedValue = sliderValue.roundToInt()
                                    val message = roundedValue.toString()
                                    if(!message.equals(messageAnterior)) {
                                        sensorViewModel.publishMessage("inTopic", message)
                                    }
                                }
                            },
                            valueRange = 0f..100f,
                            steps = 10,
                            colors = SliderDefaults.colors(
                                thumbColor = Color(0xFFfb846f),
                                activeTrackColor = Color(0xFFfb846f),
                                inactiveTrackColor = Color.White
                            )
                        )

                    Text(
                        text = "Valor de intensidad: ${sliderValue.toInt()}",
                        color = Color.White
                        )

                    Text(
                        text = alerta,
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = Color.White,
                            fontFamily = FontFamily(Font(R.font.ubuntulight))
                        ),
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .align(Alignment.CenterHorizontally),
                    )

                }

            }

        }
    )
}
