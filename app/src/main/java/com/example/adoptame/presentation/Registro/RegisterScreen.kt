package com.example.adoptame.presentation.Registro

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
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adoptame.R
import com.example.adoptame.ui.theme.Primary

private val Primary = Color(0xFF4CAF50)
private val Background = Color(0xFFF6F8FB)

@Composable
fun RegisterScreen(
    onRegister: () -> Unit,
    onLogin: () -> Unit
) {

    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    var showPassword by remember { mutableStateOf(false) }
    var showConfirm by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .statusBarsPadding()
            .navigationBarsPadding()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp)
    ) {

        IconButton(
            onClick = onLogin
        ) {
            Icon(Icons.Default.ArrowBack, null)
        }

        Spacer(Modifier.height(8.dp))

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(
                    modifier = Modifier
                        .size(110.dp)
                        .background(
                            Primary.copy(alpha = .12f),
                            CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {

                    Image(
                        painter = painterResource(R.drawable.registro),
                        contentDescription = null,
                        modifier = Modifier.size(80.dp)
                    )
                }

                Spacer(Modifier.height(20.dp))

                Text(
                    text = "¡Crea tu cuenta!",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(8.dp))

                Text(
                    text = "Únete y ayuda a perros y gatos\n a encontrar un hogar.",
                    textAlign = TextAlign.Center,
                    color = Color.Gray,
                    fontSize = 15.sp
                )
            }
        }

        Spacer(Modifier.height(28.dp))

        Card(
            shape = RoundedCornerShape(24.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                OutlinedTextField(
                    value = nombre,
                    onValueChange = { nombre = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text("Nombre completo") },
                    leadingIcon = {
                        Icon(
                            Icons.Default.Person,
                            null,
                            tint = Primary
                        )
                    },
                    shape = RoundedCornerShape(18.dp),
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Primary,
                        focusedLabelColor = Primary
                    )
                )

                Spacer(Modifier.height(16.dp))

                OutlinedTextField(
                    value = correo,
                    onValueChange = { correo = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text("Correo electrónico") },
                    leadingIcon = {
                        Icon(
                            Icons.Default.Email,
                            null,
                            tint = Primary
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    ),
                    singleLine = true,
                    shape = RoundedCornerShape(18.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Primary,
                        focusedLabelColor = Primary
                    )
                )

                Spacer(Modifier.height(16.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text("Contraseña") },
                    leadingIcon = {
                        Icon(
                            Icons.Default.Lock,
                            null,
                            tint = Primary
                        )
                    },
                    trailingIcon = {
                        IconButton(
                            onClick = {
                                showPassword = !showPassword
                            }
                        ) {
                            Icon(
                                if (showPassword)
                                    Icons.Default.VisibilityOff
                                else
                                    Icons.Default.Visibility,
                                null
                            )
                        }
                    },
                    visualTransformation =
                        if (showPassword)
                            VisualTransformation.None
                        else
                            PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    ),
                    singleLine = true,
                    shape = RoundedCornerShape(18.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Primary,
                        focusedLabelColor = Primary
                    )
                )

                Spacer(Modifier.height(16.dp))

                OutlinedTextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text("Confirmar contraseña") },
                    leadingIcon = {
                        Icon(
                            Icons.Default.Lock,
                            null,
                            tint = Primary
                        )
                    },
                    trailingIcon = {
                        IconButton(
                            onClick = {
                                showConfirm = !showConfirm
                            }
                        ) {
                            Icon(
                                if (showConfirm)
                                    Icons.Default.VisibilityOff
                                else
                                    Icons.Default.Visibility,
                                null
                            )
                        }
                    },
                    visualTransformation =
                        if (showConfirm)
                            VisualTransformation.None
                        else
                            PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    ),
                    singleLine = true,
                    shape = RoundedCornerShape(18.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Primary,
                        focusedLabelColor = Primary
                    )
                )
            }
        }

        Spacer(Modifier.height(28.dp))

        Button(
            onClick = onRegister,
            modifier = Modifier
                .fillMaxWidth()
                .height(58.dp),
            shape = RoundedCornerShape(18.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Primary
            )
        ) {

            Icon(Icons.Default.Person, null)

            Spacer(Modifier.width(8.dp))

            Text(
                "Crear mi cuenta",
                fontSize = 17.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(Modifier.height(28.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            Text(
                "¿Ya tienes cuenta?"
            )

            Spacer(Modifier.width(6.dp))

            Text(
                text = "Inicia sesión",
                color = Primary,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    onLogin()
                }
            )
        }

        Spacer(Modifier.height(32.dp))
    }
}