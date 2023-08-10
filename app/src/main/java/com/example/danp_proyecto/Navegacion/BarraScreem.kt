package com.example.danp_proyecto.Navegacion

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BarraScreem(
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object Inicio: BarraScreem(
        route = "inicio",
        title = "Inicio",
        icon = Icons.Default.Home
    )

    object Cuenta: BarraScreem(
        route = "cuenta",
        title = "Cuenta",
        icon = Icons.Default.AccountCircle
    )

    object Slider: BarraScreem(
        route = "sensor",
        title = "Sensor",
        icon = Icons.Default.Edit
    )

    object Sensor: BarraScreem(
        route = "grafico",
        title = "Grafico",
        icon = Icons.Default.Notifications
    )

}