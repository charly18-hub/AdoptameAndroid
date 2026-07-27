package com.example.adoptame.presentation.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.adoptame.presentation.Registro.RegisterActivity
import com.example.adoptame.presentation.SelectSpecie.SelectEspecieActivity
import com.example.adoptame.ui.theme.AdoptameTheme

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            AdoptameTheme {

                LoginScreen(

                    onLoginClick = {

                        startActivity(
                            Intent(
                                this,
                                SelectEspecieActivity::class.java
                            )
                        )

                        finish()

                    },

                    onRegisterClick = {

                        startActivity(
                            Intent(
                                this,
                                RegisterActivity::class.java
                            )
                        )

                    }

                )

            }

        }

    }

}