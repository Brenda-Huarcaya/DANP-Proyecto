package com.example.danp_proyecto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.danp_proyecto.Navegacion.Navegacion
import com.example.danp_proyecto.uis.screen_sensor.SensorDataViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel:ViewModel by viewModels()
    private val sensorDataViewModel: SensorDataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navegacion(viewModel,sensorDataViewModel)
        }
    }
}

