package com.example.danp_proyecto.Navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.danp_proyecto.CuentaScreen
import com.example.danp_proyecto.InicioScreen
import com.example.danp_proyecto.uis.screen_sensor.SensorScreen
import com.example.danp_proyecto.ViewModel
import com.example.danp_proyecto.uis.screen_sensor.SensorDataViewModel

@Composable
fun Navegacion(
    viewModel: ViewModel,
    sensorDataViewModel: SensorDataViewModel,
    navController: NavHostController = rememberNavController(),
    startDestination: String = BarraScreem.Cuenta.route,
){

    NavHost(
        navController = navController,
        startDestination = startDestination)
    {
        composable(route = BarraScreem.Inicio.route){
            InicioScreen(navController, viewModel)
        }
        composable(route = BarraScreem.Cuenta.route){
            CuentaScreen(navController)
        }
        composable(route = BarraScreem.Sensor.route){
            SensorScreen(navController, sensorDataViewModel)
        }
    }

}