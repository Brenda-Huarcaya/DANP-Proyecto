package com.example.danp_proyecto

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.danp_proyecto.Navegacion.BarraNavegacion

@Composable
fun CuentaScreen(navController: NavHostController) {
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
                    )
            ) {
                Spacer(modifier = Modifier.height(50.dp))

                Surface(
                    modifier = Modifier
                        .width(180.dp)
                        .height(180.dp)
                        .clip(RoundedCornerShape(100.dp))
                        .align(Alignment.CenterHorizontally),
                    color = Color(0x39FFFFFF)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .size(150.dp)
                                .clip(RoundedCornerShape(100.dp))
                                .background(Color.Gray)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.conejo),
                                contentDescription = "gato",
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Snowball",
                    style = TextStyle(fontSize = 24.sp, color = Color.White),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .height(48.dp)
                        .wrapContentSize(Alignment.Center)
                        .padding(8.dp),
                )

                Spacer(modifier = Modifier.height(16.dp))

                Surface(
                    modifier = Modifier
                        .width(280.dp)
                        .height(130.dp)
                        .align(Alignment.CenterHorizontally),
                    color = Color(0x39FFFFFF)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Nombre: Snowball",
                            style = TextStyle(fontSize = 17.sp, color = Color.White)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "E-mail: Snowball@gmail.com",
                            style = TextStyle(fontSize = 17.sp, color = Color.White)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Telefono: 987654312",
                            style = TextStyle(fontSize = 17.sp, color = Color.White)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Surface(
                    modifier = Modifier
                        .width(280.dp)
                        .height(130.dp)
                        .align(Alignment.CenterHorizontally),
                    color = Color(0x39FFFFFF)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Hogar",
                            style = TextStyle(fontSize = 17.sp, color = Color.White)
                        )
                        Text(
                            text = "Av. Villa bonito",
                            style = TextStyle(fontSize = 17.sp, color = Color.White)
                        )
                        Text(
                            text = "Sensores del Hogar: \n - Sensor de Luz",
                            style = TextStyle(fontSize = 17.sp, color = Color.White)
                        )
                    }
                }
            }

        }
    )
}