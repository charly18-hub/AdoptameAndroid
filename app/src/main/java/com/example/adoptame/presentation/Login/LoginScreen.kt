package com.example.adoptame.presentation.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.example.adoptame.presentation.Components.LoginBackground
import com.example.adoptame.presentation.Components.LoginHeader
import com.example.adoptame.presentation.Components.ForgotPasswordText
import com.example.adoptame.presentation.Components.PasswordField
import com.example.adoptame.presentation.Components.PrimaryButton
import com.example.adoptame.presentation.Components.RegisterText
import com.example.adoptame.ui.components.EmailField


@Composable
fun LoginScreen(
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit
) {

    var email by rememberSaveable {
        mutableStateOf("")
    }

    var password by rememberSaveable {
        mutableStateOf("")
    }


    androidx.compose.foundation.layout.Box(
        modifier = Modifier.fillMaxSize()
    ) {


        LoginBackground()


        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(
                    rememberScrollState()
                )
                .padding(24.dp),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {


            Card(

                modifier = Modifier
                    .widthIn(max = 420.dp),

                shape = RoundedCornerShape(24.dp),

                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                )

            ) {


                Column(

                    modifier = Modifier
                        .padding(24.dp),

                    horizontalAlignment = Alignment.CenterHorizontally

                ) {


                    LoginHeader()


                    Spacer(
                        modifier = Modifier.padding(8.dp)
                    )


                    EmailField(

                        email = email,

                        onEmailChange = {
                            email = it
                        }

                    )


                    Spacer(
                        modifier = Modifier.padding(8.dp)
                    )

                    PasswordField(

                        password = password,

                        onPasswordChange = {
                            password = it
                        }

                    )


                    ForgotPasswordText(
                        onClick = {

                        }
                    )


                    PrimaryButton(
                        text = "ENTRAR",
                        onClick = onLoginClick
                    )

                    Spacer(
                        modifier = Modifier.padding(8.dp)
                    )


                    PrimaryButton(

                        text = "ENTRAR",

                        onClick = onLoginClick

                    )


                    Spacer(
                        modifier = Modifier.padding(8.dp)
                    )


                    RegisterText(
                        onClick = onRegisterClick
                    )

                }

            }

        }

    }

}