package com.example.danp_proyecto

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
                        color = Color(0xFF6379e6)
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Sensores de la casa",
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
                        .align(Alignment.CenterHorizontally),
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                            Image(
                                painter = painterResource(id = R.drawable.casa),
                                contentDescription = "casa",
                            )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Snowball",
                    style = TextStyle(
                        fontSize = 25.sp,
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.luckiestguyregular))
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .wrapContentSize(Alignment.Center)
                        .padding(8.dp),
                )

                Spacer(modifier = Modifier.height(16.dp))

                /*
                Surface(
                    modifier = Modifier
                        .width(300.dp)
                        .height(150.dp)
                        .align(Alignment.CenterHorizontally),
                    shape = MaterialTheme.shapes.medium,
                    color = Color.White
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                            .fillMaxSize()
                    ) {
                        Text(
                            text = "Casa: Snowball",
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color(0xFFfb846f),
                                fontFamily = FontFamily(Font(R.font.ubunturegular))
                            )
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "E-mail: Snowball@gmail.com",
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color(0xFFfb846f),
                                fontFamily = FontFamily(Font(R.font.ubunturegular))
                            )
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Telefono: 987654312",
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color(0xFFfb846f),
                                fontFamily = FontFamily(Font(R.font.ubunturegular))
                            )
                        )

                    }
                }

                 */
                Spacer(modifier = Modifier.height(16.dp))

                Surface(
                    modifier = Modifier
                        .width(300.dp)
                        .height(150.dp)
                        .align(Alignment.CenterHorizontally),
                    shape = MaterialTheme.shapes.medium,
                    color = Color.White
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp)
                            .fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.detector),
                            contentDescription = "detector",
                            modifier = Modifier
                                .size(width = 120.dp, height = 120.dp)
                        )
                        Text(
                            text = "Sensor de Humo",
                            style = TextStyle(
                                fontSize = 35.sp,
                                color = Color(0xFFfb846f),
                                fontFamily = FontFamily(Font(R.font.luckiestguyregular)),
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier
                                .padding(start = 16.dp)
                        )

                    }
                }

            }

        }
    )
}