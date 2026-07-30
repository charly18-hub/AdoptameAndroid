package com.example.adoptame.presentation.SelectSpecie

import SelectSpecieScreen
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.adoptame.presentation.Formulario.FormularioActivity
import com.example.adoptame.ui.theme.AdoptameTheme

class SelectEspecieActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AdoptameTheme {

                SelectSpecieScreen(

                    onDogs = {
                        navigateFormulario("1")
                    },

                    onCats = {
                        navigateFormulario("2")
                    }

                )
            }
        }
    }

    private fun navigateFormulario(type: String) {

        getSharedPreferences(
            "PREFERENCE_NAME",
            MODE_PRIVATE
        ).edit()
            .putString("especieType", type)
            .apply()

        startActivity(
            Intent(this, FormularioActivity::class.java)
        )

        finish()
    }
}