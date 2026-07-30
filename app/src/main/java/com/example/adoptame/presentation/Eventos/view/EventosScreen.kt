package com.example.adoptame.presentation.Eventos.view

import com.example.adoptame.domain.entity.Events
import com.example.adoptame.presentation.Eventos.viewModel.EventsUiState

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.adoptame.R


private val PrimaryBlue = Color(0xFF1193E8)
private val Purple = Color(0xFF6327D9)


@Composable
fun EventosScreen(
    state: EventsUiState,
    onBack: () -> Unit
) {

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(

                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFF5E5FF),
                        Color.White
                    )
                )

            )

    ) {


        // HEADER

        Box(

            modifier = Modifier
                .fillMaxWidth()
                .background(
                    PrimaryBlue
                )
                .statusBarsPadding()
                .padding(
                    vertical = 22.dp
                ),

            contentAlignment = Alignment.Center

        ) {


            Column(

                horizontalAlignment = Alignment.CenterHorizontally

            ) {


                Text(

                    text = "Eventos de adopción",

                    color = Color.White,

                    fontSize = 26.sp,

                    fontWeight = FontWeight.Bold

                )


                Spacer(
                    Modifier.height(4.dp)
                )


                Text(

                    text = "Participa y ayuda a más mascotas",

                    color = Color.White.copy(
                        alpha = 0.9f
                    ),

                    fontSize = 13.sp

                )

            }

        }



        LazyColumn(

            modifier = Modifier.fillMaxSize(),

            contentPadding = PaddingValues(
                16.dp
            ),

            verticalArrangement = Arrangement.spacedBy(
                18.dp
            )

        ) {


            items(state.events) { event ->


                EventCard(
                    event = event
                )


            }

        }


    }

}




@Composable
fun EventCard(

    event: Events

) {


    Card(

        modifier = Modifier
            .fillMaxWidth(),

        shape = RoundedCornerShape(
            24.dp
        ),

        colors = CardDefaults.cardColors(

            containerColor = Color.White

        ),

        elevation = CardDefaults.cardElevation(

            defaultElevation = 6.dp

        )

    ) {



        Column {


            Box {


                AsyncImage(

                    model =  R.drawable.pet,

                    contentDescription = "Evento",

                    modifier = Modifier

                        .fillMaxWidth()

                        .height(
                            200.dp
                        )

                        .clip(
                            RoundedCornerShape(
                                topStart = 24.dp,
                                topEnd = 24.dp
                            )
                        ),

                    contentScale = ContentScale.Crop

                )



                // BADGE EVENTO

                Box(

                    modifier = Modifier

                        .padding(14.dp)

                        .background(

                            Purple,

                            RoundedCornerShape(
                                50
                            )

                        )

                        .padding(
                            horizontal = 14.dp,
                            vertical = 6.dp
                        )

                ) {


                    Text(

                        text = "Adopción",

                        color = Color.White,

                        fontWeight = FontWeight.Bold,

                        fontSize = 12.sp

                    )


                }



            }



            Column(

                modifier = Modifier
                    .padding(
                        16.dp
                    )

            ) {



                Text(

                    text = "Evento para encontrar hogar",

                    fontSize = 20.sp,

                    fontWeight = FontWeight.Bold,

                    color = Color(0xFF0F172A)

                )



                Spacer(
                    Modifier.height(12.dp)
                )



                Row(

                    verticalAlignment = Alignment.CenterVertically

                ) {


                    Icon(

                        Icons.Default.CalendarMonth,

                        null,

                        tint = PrimaryBlue,

                        modifier = Modifier.size(
                            20.dp
                        )

                    )


                    Spacer(
                        Modifier.width(8.dp)
                    )


                    Text(

                        text = event.date,

                        color = Color(0xFF475569),

                        fontSize = 14.sp

                    )


                }



                Spacer(
                    Modifier.height(8.dp)
                )



                Row(

                    verticalAlignment = Alignment.CenterVertically

                ) {


                    Icon(

                        Icons.Default.LocationOn,

                        null,

                        tint = Color.Red,

                        modifier = Modifier.size(
                            20.dp
                        )

                    )


                    Spacer(
                        Modifier.width(8.dp)
                    )


                    Text(

                        text = "Ubicación del evento",

                        color = Color(0xFF475569),

                        fontSize = 14.sp

                    )


                }




                Spacer(
                    Modifier.height(8.dp)
                )



                Row(

                    verticalAlignment = Alignment.CenterVertically

                ) {


                    Icon(

                        Icons.Default.Pets,

                        null,

                        tint = Purple,

                        modifier = Modifier.size(
                            20.dp
                        )

                    )


                    Spacer(
                        Modifier.width(8.dp)
                    )


                    Text(

                        text = "Mascotas disponibles",

                        color = Color(0xFF475569),

                        fontSize = 14.sp

                    )


                }



                Spacer(
                    Modifier.height(16.dp)
                )



                Button(

                    onClick = {},

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(
                            50.dp
                        ),

                    shape = RoundedCornerShape(
                        50
                    ),

                    colors = ButtonDefaults.buttonColors(

                        containerColor = Purple

                    )

                ) {


                    Icon(

                        Icons.Default.Verified,

                        null,

                        modifier = Modifier.size(
                            18.dp
                        )

                    )


                    Spacer(
                        Modifier.width(8.dp)
                    )


                    Text(

                        text = "Ver detalles del evento",

                        fontWeight = FontWeight.Bold

                    )


                }


            }


        }


    }


}