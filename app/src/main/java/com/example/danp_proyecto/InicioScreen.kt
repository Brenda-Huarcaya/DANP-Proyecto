package com.example.danp_proyecto

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Button
import androidx.compose.material.Slider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material.Text
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.danp_proyecto.Navegacion.BarraNavegacion

@Composable
fun InicioScreen(navController: NavHostController, sensorvm: ViewModel) {

    var indiceImagen by remember { mutableStateOf(0) }

    val imagenes: List<Painter> = listOf(
        painterResource(id = R.drawable.fuegoapagado),
        painterResource(id = R.drawable.fuegoprendido)
    )

    //var showSecondImage by remember { mutableStateOf(false) }
    //var sliderValue by remember { mutableStateOf(0f) }

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
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                )
                    {
                        Image(
                            //painter = if (showSecondImage) painterResource(id = R.drawable.fuegoapagado)
                               //         else painterResource(id = R.drawable.fuegoprendido),
                            painter = imagenes[indiceImagen],
                            contentDescription = null,
                            modifier = Modifier
                                .size(200.dp)
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "FireHome",
                            style = TextStyle(
                                fontSize = 50.sp,
                                color = Color.White,
                                fontFamily = FontFamily(Font(R.font.luckiestguyregular))
                            ),
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .wrapContentSize(Alignment.Center)
                                .padding(8.dp),
                        )

                        Row() {

                            Button(
                                modifier = Modifier
                                    .height(50.dp)
                                    .width(80.dp)
                                    .pointerInput(Unit) {
                                        detectTapGestures {
                                            indiceImagen = 0
                                        }
                                    },
                                shape = RoundedCornerShape(16.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = if (indiceImagen == 0) Color.White else Color(0xFFfb846f),
                                    contentColor = if (indiceImagen == 0) Color(0xFFfb846f) else Color.White
                                ),
                                onClick = {
                                    //showSecondImage = !showSecondImage
                                    indiceImagen = 1
                                    sensorvm.publishMessage("inTopic", "1")
                                }
                            ) {
                                Text(text = "ON")
                            }

                            Spacer(modifier = Modifier.width(10.dp))

                            Button(
                                modifier = Modifier
                                    .height(50.dp)
                                    .width(80.dp)
                                    .pointerInput(Unit) {
                                        detectTapGestures {
                                            indiceImagen = 1
                                        }
                                    },
                                shape = RoundedCornerShape(16.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = if (indiceImagen == 1) Color.White else Color(0xFFfb846f),
                                    contentColor = if (indiceImagen == 1) Color(0xFFfb846f) else Color.White
                                ),
                                onClick = {
                                    sensorvm.publishMessage("inTopic", "0")
                                    //showSecondImage = !showSecondImage
                                    indiceImagen = 0
                                }
                            ) {
                                Text(text = "OFF")
                            }
                        }
                    }

            }

        }
    )
}