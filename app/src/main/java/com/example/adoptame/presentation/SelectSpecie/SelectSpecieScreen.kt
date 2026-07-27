package com.example.adoptame.presentation.SelectSpecie

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adoptame.R

private val BackgroundBlue = Color(0xFF2D98BF)

@Composable
fun SelectSpecieScreen(
    onDogClick: () -> Unit,
    onCatClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundBlue)
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "¿Quién será tu nuevo amigo?",
            color = Color.White,
            fontSize = 33.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Cursive
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Elige una especie para comenzar",
            color = Color.White,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(42.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {

            SpecieCard(
                image = R.drawable.cat11,
                title = "Gatos",
                onClick = onCatClick
            )

            Spacer(modifier = Modifier.width(42.dp))

            SpecieCard(
                image = R.drawable.dog2,
                title = "Perros",
                onClick = onDogClick
            )

        }

        Spacer(modifier = Modifier.weight(2f))
    }

}

@Composable
private fun SpecieCard(
    image: Int,
    title: String,
    onClick: () -> Unit
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
    ) {

        Card(
            modifier = Modifier.size(145.dp),
            shape = CircleShape,
            elevation = CardDefaults.cardElevation(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                Image(
                    painter = painterResource(image),
                    contentDescription = title,
                    modifier = Modifier
                        .size(140.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

            }

        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = title,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 21.sp
        )

    }

}