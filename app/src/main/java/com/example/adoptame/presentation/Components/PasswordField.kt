package com.example.adoptame.presentation.Components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun PasswordField(
    password: String,
    onPasswordChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    var passwordVisible by rememberSaveable {
        mutableStateOf(false)
    }

    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChange,
        modifier = modifier.fillMaxWidth(),
        singleLine = true,
        label = {
            Text("Contraseña")
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = null
            )
        },
        trailingIcon = {

            IconButton(
                onClick = {
                    passwordVisible = !passwordVisible
                }
            ) {

                Icon(
                    imageVector = if (passwordVisible)
                        Icons.Default.VisibilityOff
                    else
                        Icons.Default.Visibility,
                    contentDescription = if (passwordVisible)
                        "Ocultar contraseña"
                    else
                        "Mostrar contraseña"
                )

            }

        },
        visualTransformation =
            if (passwordVisible)
                VisualTransformation.None
            else
                PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        )
    )

}