package com.example.adoptame.utils

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.adoptame.domain.entity.Pet
import com.example.adoptame.presentation.Adoptados.view.AdoptadosScreen
import com.example.adoptame.presentation.Adoptados.view.DetalleMascotaScreen
import com.example.adoptame.presentation.Adoptados.viewmodel.AdoptadosViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun AppNavigation(
    viewModel: AdoptadosViewModel,
    finishActivity: () -> Unit
) {

    var selectedPet by remember {
        mutableStateOf<Pet?>(null)
    }

    val navController = rememberNavController()

    val state by viewModel.uiState.collectAsStateWithLifecycle()


    NavHost(
        navController = navController,
        startDestination = "mascotas"
    ) {

        composable("mascotas") {

            AdoptadosScreen(
                state = state,
                onBack = finishActivity,
                onPetClick = { pet ->

                    selectedPet = pet

                    navController.navigate("detalleMascota")

                }
            )

        }


        composable("detalleMascota") {

            selectedPet?.let { pet ->

                DetalleMascotaScreen(
                    navController = navController,
                    pet = pet
                )

            }

        }

    }
}