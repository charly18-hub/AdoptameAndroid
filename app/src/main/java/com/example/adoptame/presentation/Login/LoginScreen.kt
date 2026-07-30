package com.example.adoptame.presentation.login

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.Facebook
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adoptame.R

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit
) {

    var isLogin by rememberSaveable { mutableStateOf(true) }

    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    var nombre by rememberSaveable { mutableStateOf("") }
    var registerEmail by rememberSaveable { mutableStateOf("") }
    var registerPassword by rememberSaveable { mutableStateOf("") }
    var confirmPassword by rememberSaveable { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF4FAFF))
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            // Header azul
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
                    .background(
                        Brush.verticalGradient(
                            listOf(
                                Color(0xFF1193E8),
                                Color(0xFF0B7ED3)
                            )
                        )
                    )
            ) {

                Column(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(24.dp)
                ) {

                    Spacer(modifier = Modifier.height(32.dp))

                    Text(
                        text = "Adóptame",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = if (isLogin)
                            "Bienvenido de nuevo"
                        else
                            "Crea una cuenta segura",
                        fontSize = 18.sp,
                        color = Color.White.copy(alpha = 0.92f)
                    )
                }

                Image(
                    painter = painterResource(R.drawable.log),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(end = 16.dp)
                        .size(210.dp),
                    contentScale = ContentScale.Fit
                )
            }

            // Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-24).dp),
                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {

                Column(
                    modifier = Modifier.padding(24.dp)
                ) {

                    // Tabs
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(18.dp))
                            .background(Color(0xFFF3F6FA))
                            .padding(4.dp)
                    ) {

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(14.dp))
                                .background(
                                    if (isLogin) Color.White else Color.Transparent
                                )
                                .clickable { isLogin = true }
                                .padding(vertical = 14.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Sign In",
                                color = if (isLogin) Color(0xFF1193E8) else Color(0xFF94A3B8),
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(14.dp))
                                .background(
                                    if (!isLogin) Color.White else Color.Transparent
                                )
                                .clickable { isLogin = false }
                                .padding(vertical = 14.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Sign Up",
                                color = if (!isLogin) Color(0xFF1193E8) else Color(0xFF94A3B8),
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(28.dp))

                    AnimatedContent(targetState = isLogin, label = "auth") { login ->

                        if (login) {

                            // LOGIN
                            Column {

                                AuthTextField(
                                    value = email,
                                    onValueChange = { email = it },
                                    placeholder = "Correo electrónico",
                                    icon = Icons.Default.Email
                                )

                                Spacer(modifier = Modifier.height(16.dp))

                                AuthTextField(
                                    value = password,
                                    onValueChange = { password = it },
                                    placeholder = "Contraseña",
                                    icon = Icons.Default.Lock,
                                    isPassword = true
                                )

                                Spacer(modifier = Modifier.height(16.dp))

                                Text(
                                    text = "¿Olvidaste tu contraseña?",
                                    modifier = Modifier.align(Alignment.End),
                                    color = Color(0xFF334155),
                                    fontSize = 14.sp
                                )

                                Spacer(modifier = Modifier.height(32.dp))

                                Button(
                                    onClick = onLoginClick,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(56.dp),
                                    shape = RoundedCornerShape(28.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(0xFF1193E8)
                                    )
                                ) {

                                    Text(
                                        "Entrar",
                                        fontSize = 17.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }

                        } else {

                            // REGISTER
                            Column {

                                AuthTextField(
                                    value = nombre,
                                    onValueChange = { nombre = it },
                                    placeholder = "Nombre completo",
                                    icon = Icons.Default.Person
                                )

                                Spacer(modifier = Modifier.height(16.dp))

                                AuthTextField(
                                    value = registerEmail,
                                    onValueChange = { registerEmail = it },
                                    placeholder = "Correo electrónico",
                                    icon = Icons.Default.Email
                                )

                                Spacer(modifier = Modifier.height(16.dp))

                                AuthTextField(
                                    value = registerPassword,
                                    onValueChange = { registerPassword = it },
                                    placeholder = "Contraseña",
                                    icon = Icons.Default.Lock,
                                    isPassword = true
                                )

                                Spacer(modifier = Modifier.height(16.dp))

                                AuthTextField(
                                    value = confirmPassword,
                                    onValueChange = { confirmPassword = it },
                                    placeholder = "Confirmar contraseña",
                                    icon = Icons.Default.Lock,
                                    isPassword = true
                                )

                                Spacer(modifier = Modifier.height(32.dp))

                                Button(
                                    onClick = onRegisterClick,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(56.dp),
                                    shape = RoundedCornerShape(28.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(0xFF1193E8)
                                    )
                                ) {

                                    Text(
                                        "Crear cuenta",
                                        fontSize = 17.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(28.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        HorizontalDivider(
                            modifier = Modifier.weight(1f),
                            color = Color(0xFFE2E8F0)
                        )

                        Text(
                            text = "  Or  ",
                            color = Color(0xFF94A3B8)
                        )

                        HorizontalDivider(
                            modifier = Modifier.weight(1f),
                            color = Color(0xFFE2E8F0)
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {

                        SocialButton(
                            icon = {
                                Icon(
                                    Icons.Outlined.Facebook,
                                    null,
                                    tint = Color(0xFF1877F2)
                                )
                            }
                        )

                        SocialButton(
                            icon = {
                                Icon(
                                    Icons.Outlined.Share,
                                    null,
                                    tint = Color(0xFF1DA1F2)
                                )
                            }
                        )

                        SocialButton(
                            icon = {
                                Text(
                                    "◎",
                                    color = Color(0xFFE1306C),
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

@Composable
private fun AuthTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    icon: ImageVector,
    isPassword: Boolean = false
) {

    var visible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        placeholder = {
            Text(
                text = placeholder,
                color = Color(0xFF94A3B8)
            )
        },
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color(0xFF94A3B8)
            )
        },
        trailingIcon = {
            if (isPassword) {
                IconButton(onClick = { visible = !visible }) {
                    Icon(
                        imageVector = if (visible)
                            Icons.Default.VisibilityOff
                        else
                            Icons.Default.Visibility,
                        contentDescription = null,
                        tint = Color(0xFF94A3B8)
                    )
                }
            }
        },
        visualTransformation =
            if (isPassword && !visible)
                PasswordVisualTransformation()
            else
                VisualTransformation.None,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFFE2E8F0),
            unfocusedBorderColor = Color(0xFFE2E8F0),
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black
        ),
        singleLine = true
    )
}
@Composable
private fun SocialButton(
    icon: @Composable () -> Unit
) {

    Box(
        modifier = Modifier
            .size(52.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFF8FAFC)),
        contentAlignment = Alignment.Center
    ) {
        icon()
    }
}
