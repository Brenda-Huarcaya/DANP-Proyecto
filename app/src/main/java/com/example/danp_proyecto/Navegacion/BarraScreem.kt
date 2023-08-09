package com.example.danp_proyecto.Navegacion

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
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

    object Sensor: BarraScreem(
        route = "sensor",
        title = "sensor",
        icon = Icons.Default.Notifications
    )
}