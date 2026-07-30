package com.example.adoptame.presentation.Asociaciones.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import com.example.adoptame.presentation.Asociaciones.viewmodel.AsociacionesUiState


private val PrimaryPurple = Color(0xFF6327D9)
private val SecondaryBlue = Color(0xFF1193E8)


@Composable
fun AsociacionesScreen(
    state: AsociacionesUiState,
    onSearch: (String) -> Unit
) {

    var search by remember {
        mutableStateOf("")
    }


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
            .statusBarsPadding()
    ) {


        // HEADER

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(130.dp)
                .clip(
                    RoundedCornerShape(28.dp)
                )
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(
                            PrimaryPurple,
                            SecondaryBlue
                        )
                    )
                )
                .padding(20.dp)

        ){

            Column {

                Text(
                    text = "Asociaciones",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )


                Spacer(
                    Modifier.height(8.dp)
                )


                Text(
                    text = "Conoce quienes ayudan a nuestros amigos peludos",
                    color = Color.White.copy(alpha = .9f),
                    fontSize = 14.sp
                )

            }

        }



        // BUSCADOR

        OutlinedTextField(

            value = search,

            onValueChange = {

                search = it
                onSearch(it)

            },

            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),

            placeholder = {
                Text(
                    "Buscar asociación..."
                )
            },

            leadingIcon = {

                Icon(
                    Icons.Default.Search,
                    null
                )

            },

            singleLine = true,

            shape = RoundedCornerShape(20.dp),

            colors = OutlinedTextFieldDefaults.colors(

                focusedBorderColor = PrimaryPurple,
                unfocusedBorderColor = Color.LightGray

            )

        )


        Spacer(
            Modifier.height(12.dp)
        )


        LazyColumn(

            modifier = Modifier.fillMaxSize(),

            contentPadding = PaddingValues(
                horizontal = 16.dp,
                vertical = 8.dp
            ),

            verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {


            items(state.associations){ association ->


                AssociationCard(
                    association = association
                )

            }


        }

    }

}



@Composable
fun AssociationCard(
    association: com.example.adoptame.domain.entity.Association
){


    Card(

        modifier = Modifier
            .fillMaxWidth(),

        shape = RoundedCornerShape(26.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )

    ){


        Column(

            modifier = Modifier
                .padding(18.dp)

        ){


            Row(
                verticalAlignment = Alignment.CenterVertically
            ){


                AsyncImage(

                    model =  R.drawable.adopta_anegl,

                    contentDescription = association.name,

                    modifier = Modifier
                        .size(75.dp)
                        .clip(CircleShape),

                    contentScale = ContentScale.Crop

                )



                Spacer(
                    Modifier.width(16.dp)
                )



                Column(
                    modifier = Modifier.weight(1f)
                ){


                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ){


                        Text(

                            association.name,

                            fontSize = 19.sp,

                            fontWeight = FontWeight.Bold,

                            color = Color.Black

                        )


                        Spacer(
                            Modifier.width(6.dp)
                        )


                        Icon(

                            Icons.Default.Verified,

                            null,

                            tint = Color(0xFF2563EB),

                            modifier = Modifier.size(18.dp)

                        )

                    }



                    Spacer(
                        Modifier.height(6.dp)
                    )



                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ){


                        Icon(

                            Icons.Default.LocationOn,

                            null,

                            tint = PrimaryPurple,

                            modifier = Modifier.size(16.dp)

                        )


                        Spacer(
                            Modifier.width(4.dp)
                        )


                        Text(

                            association.city,

                            color = Color.Gray,

                            fontSize = 14.sp

                        )

                    }

                }


            }



            Spacer(
                Modifier.height(18.dp)
            )



            Row(

                horizontalArrangement = Arrangement.spacedBy(10.dp)

            ){


                AnimalBadge(
                    icon = "🐶",
                    text = "${association.dogs} perros"
                )


                AnimalBadge(
                    icon = "🐱",
                    text = "${association.cats} gatos"
                )


            }



            Spacer(
                Modifier.height(18.dp)
            )



            Button(

                onClick = {

                },

                modifier = Modifier.fillMaxWidth(),

                shape = RoundedCornerShape(18.dp),

                colors = ButtonDefaults.buttonColors(

                    containerColor = PrimaryPurple

                )

            ){

                Icon(
                    Icons.Default.Pets,
                    null
                )

                Spacer(
                    Modifier.width(8.dp)
                )


                Text(
                    "Conocer asociación"
                )

            }


        }

    }

}



@Composable
fun AnimalBadge(
    icon:String,
    text:String
){


    Box(

        modifier = Modifier

            .background(

                Color(0xFFF1F5F9),

                RoundedCornerShape(50)

            )

            .padding(
                horizontal = 12.dp,
                vertical = 6.dp
            )

    ){

        Text(

            text = "$icon $text",

            fontSize = 13.sp,

            color = Color.DarkGray

        )

    }

}