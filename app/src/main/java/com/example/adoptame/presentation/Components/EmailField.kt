package com.example.adoptame.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.adoptame.ui.theme.AdoptameTheme
import com.example.adoptame.ui.theme.Background
import com.example.adoptame.ui.theme.Border
import com.example.adoptame.ui.theme.Hint
import com.example.adoptame.ui.theme.Primary

@Composable
fun EmailField(
    email: String,
    onEmailChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    OutlinedTextField(
        value = email,
        onValueChange = onEmailChange,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        singleLine = true,
        shape = RoundedCornerShape(12.dp),

        placeholder = {
            Text("Correo electrónico")
        },

        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null
            )
        },

        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),

        colors = OutlinedTextFieldDefaults.colors(

            focusedBorderColor = Border,
            unfocusedBorderColor = Border,

            focusedLeadingIconColor = Primary,
            unfocusedLeadingIconColor = Primary,

            focusedPlaceholderColor = Hint,
            unfocusedPlaceholderColor = Hint,

            cursorColor = Primary,

            focusedContainerColor = Background,
            unfocusedContainerColor = Background

        )

    )

}

@Preview(showBackground = true)
@Composable
private fun EmailFieldPreview() {

    AdoptameTheme {

        EmailField(
            email = "",
            onEmailChange = {}
        )

    }

}