package com.example.adoptame.presentation.Registro

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.adoptame.presentation.SelectSpecie.SelectEspecieActivity
import com.example.adoptame.ui.theme.AdoptameTheme

class RegisterActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AdoptameTheme {
                RegisterScreen(
                    onRegister = {
                        navSelectEspecie()
                    },
                    onLogin = {
                        finish()
                    }
                )
            }
        }
    }

    private fun navSelectEspecie() {
        val intent = Intent(this, SelectEspecieActivity::class.java)
        startActivity(intent)
        finish()
    }
}