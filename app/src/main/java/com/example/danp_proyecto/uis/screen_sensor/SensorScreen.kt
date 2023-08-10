package com.example.danp_proyecto.uis.screen_sensor

import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.danp_proyecto.Navegacion.BarraNavegacion
import com.example.danp_proyecto.R
import com.himanshoe.charty.common.ChartDataCollection
import com.himanshoe.charty.common.config.AxisConfig
import com.himanshoe.charty.line.CurveLineChart
import com.himanshoe.charty.line.config.LineConfig
import com.himanshoe.charty.line.model.LineData
import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter


@Composable
fun SensorScreen(navController: NavHostController, sensorViewModel: SensorDataViewModel) {
    val datosSensor: List<LineData> = sensorViewModel.dataList
    var isPressed by remember { mutableStateOf(false) }

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
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = "Grafico del sensor",
                            style = TextStyle(
                                fontSize = 25.sp,
                                color = Color(0xFFfb846f),
                                fontFamily = FontFamily(Font(R.font.luckiestguyregular))
                            ),
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .align(Alignment.CenterHorizontally),
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = "Grafico en tiempo real de los datos del sensor",
                            style = TextStyle(
                                fontSize = 15.sp,
                                color = Color.White,
                                fontFamily = FontFamily(Font(R.font.ubuntulight))
                            ),
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .align(Alignment.CenterHorizontally),
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        if (datosSensor.size != 0) {
                            LinearChart(datosSensor)
                        }

                        Spacer(modifier = Modifier.height(30.dp))

                        Button(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .height(50.dp)
                                .width(150.dp)
                                .pointerInput(Unit) {
                                    detectTapGestures {
                                        isPressed = true
                                    }
                                },
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = if (isPressed) Color.White else Color(0xFFfb846f),
                                contentColor = if (isPressed) Color(0xFFfb846f) else Color.White
                            ),
                            onClick = {
                                isPressed = !isPressed
                                sensorViewModel.subscribeTopicSensor()
                                //sensorViewModel.subscribeTopicAlerta()
                            },
                        ) {
                            val textColor = if (isPressed) Color(0xFFfb846f) else Color.White
                            Text(
                                text = "GRAFICAR",
                                color = textColor
                            )
                        }

                        Spacer(modifier = Modifier.height(30.dp))


                    }


            }
        }
    )
}

@Composable
fun LinearChart(datosSensor: List<LineData>) {
    CurveLineChart(
        //DATOS PARA EL GRAFICO
        dataCollection = ChartDataCollection(datosSensor),
        modifier = Modifier
            .padding(start = 12.dp, top = 10.dp)
            .height(300.dp),
        padding = 15.dp,
        radiusScale = 0.01f,
        axisConfig = AxisConfig(
            minLabelCount = 6,
            showAxes = true,
            showGridLabel = true,
            showGridLines = false,
            axisColor = Color.White,
            axisStroke = 1.0f
        ),
    )
}
