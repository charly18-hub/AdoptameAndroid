package com.example.adoptame.presentation.Components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.adoptame.ui.theme.Primary

@Composable
fun RegisterText(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    TextButton(
        onClick = onClick,
        modifier = modifier.fillMaxWidth()
    ) {

        Text(
            text = "¿No tienes cuenta? Regístrate",
            color = Primary,
            textAlign = TextAlign.Center
        )

    }

}