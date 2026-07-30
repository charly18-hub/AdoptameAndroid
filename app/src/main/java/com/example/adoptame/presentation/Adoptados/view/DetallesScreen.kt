package com.example.adoptame.presentation.Adoptados.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.adoptame.R
import com.example.adoptame.domain.entity.Pet

data class Pets(
    val name: String,
    val breed: String,
    val age: String,
    val gender: String,
    val size: String,
    val location: String,
    val description: String,
    val image:Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalleMascotaScreen(
    navController: NavHostController,
    pet: Pet
) {

    Scaffold(

        topBar = {

            TopAppBar(

                title = {
                    Text(
                        pet.name,
                        color = Color.Black
                    )
                },

                navigationIcon = {

                    IconButton(
                        onClick = { navController.popBackStack() }
                    ) {

                        Icon(
                            Icons.Default.ArrowBack,
                            null,
                            tint = Color.Black
                        )

                    }

                }

            )

        }

    ) { padding ->

        Column(

            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color(0xFFF5E5FF),
                            Color.White
                        )
                    )
                )
                .verticalScroll(rememberScrollState())
                .padding(16.dp)

        ) {

            Card(
                shape = RoundedCornerShape(16.dp)
            ) {

                AsyncImage(
                    model = R.drawable.bg2,
                    contentDescription = pet.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop
                )

            }

            Spacer(Modifier.height(20.dp))

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {

                Column(
                    Modifier.padding(16.dp)
                ) {

                    Text(
                        pet.name,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(Modifier.height(12.dp))

                    DetailItem("Raza", pet.breed)
                    DetailItem("Edad", pet.age)
                    DetailItem("Sexo", pet.age)
                    DetailItem("Tamaño", pet.breed)
                    DetailItem("Ubicación", pet.name)

                }

            }

            Spacer(Modifier.height(16.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(16.dp)
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ){

                    Text(
                        "Acerca de mí",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.Black
                    )

                    Spacer(Modifier.height(10.dp))

                    Text(
                        pet.name,
                        color = Color.Black
                    )

                }

            }

            Spacer(Modifier.height(16.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(16.dp)
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Icon(
                            Icons.Default.Shield,
                            null,
                            tint = Color(0xFF6327D9)
                        )

                        Spacer(Modifier.width(8.dp))

                        Text(
                            "Vacunas completas",
                            color = Color.Black
                        )

                    }

                    Spacer(Modifier.height(12.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Icon(
                            Icons.Default.Pets,
                            null,
                            tint = Color(0xFF6327D9)
                        )

                        Spacer(Modifier.width(8.dp))

                        Text(
                            "Esterilizado",
                            color = Color.Black
                        )

                    }

                    Spacer(Modifier.height(12.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Icon(
                            Icons.Default.Favorite,
                            null,
                            tint = Color(0xFF6327D9)
                        )

                        Spacer(Modifier.width(8.dp))

                        Text(
                            "Muy cariñoso y sociable",
                            color = Color.Black
                        )

                    }

                    Spacer(Modifier.height(12.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Icon(
                            Icons.Default.Place,
                            null,
                            tint = Color(0xFF6327D9)
                        )

                        Spacer(Modifier.width(8.dp))

                        Text(
                            pet.name,
                            color = Color.Black
                        )

                    }

                }

            }

            Spacer(Modifier.height(24.dp))

            Button(

                onClick = {

                },

                modifier = Modifier.fillMaxWidth(),

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6327D9)
                )

            ) {

                Text(
                    "Quiero Adoptarlo",
                    color = Color.White
                )

            }

            Spacer(Modifier.height(30.dp))

        }

    }

}

@Composable
fun DetailItem(
    title:String,
    value:String
){

    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){

        Text(
            title,
            color = Color.Gray
        )

        Text(
            value,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

    }

}