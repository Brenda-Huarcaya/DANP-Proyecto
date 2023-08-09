package com.example.danp_proyecto.uis.screen_sensor

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.danp_proyecto.Navegacion.BarraNavegacion
import com.himanshoe.charty.common.ChartDataCollection
import com.himanshoe.charty.common.config.AxisConfig
import com.himanshoe.charty.line.CurveLineChart
import com.himanshoe.charty.line.model.LineData

@Composable
fun SensorScreen(navController: NavHostController, sensorViewModel: SensorDataViewModel) {
    val datosSensor: List<LineData> = sensorViewModel.dataList
    val alerta: String by sensorViewModel.datito.observeAsState("NO DATOS")

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
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(
                            text = "SENSOR SCREEN",
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .align(Alignment.CenterHorizontally),
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        OutlinedButton(
                            onClick = { sensorViewModel.subscribeTopicSensor() },
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.Blue,
                                contentColor = Color.White
                            )
                        ) {
                            Text(text = "Actualizar conexión")
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        if (datosSensor.size != 0) {
                            LinearChart(datosSensor)
                        }
                        Spacer(modifier = Modifier.height(30.dp))

                        Text(
                            text = alerta,
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .align(Alignment.CenterHorizontally),
                        )
                    }

                }
            }
        }
    )
}

@Composable
fun LinearChart(datosSensor: List<LineData>) {
    CurveLineChart(
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
            axisColor = Color.Gray,
            axisStroke = 1.0f
        ),
    )
}