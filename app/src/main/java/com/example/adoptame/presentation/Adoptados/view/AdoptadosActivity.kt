package com.example.adoptame.presentation.Adoptados.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.adoptame.data.repository.PetRepositoryImpl
import com.example.adoptame.domain.usecase.GetPetsUseCase
import com.example.adoptame.presentation.Adoptados.viewmodel.AdoptadosViewModel
import com.example.adoptame.presentation.Adoptados.viewmodel.AdoptadosViewModelFactory
import com.example.adoptame.utils.AppNavigation
import com.example.adoptame.utils.GetSpecieUtils

class AdoptadosActivity : ComponentActivity() {

    private val viewModel: AdoptadosViewModel by viewModels {

        val repository = PetRepositoryImpl()
        val useCase = GetPetsUseCase(repository)

        AdoptadosViewModelFactory(useCase)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val especie = GetSpecieUtils().getSpecie(this)

        when (especie) {
            "1" -> viewModel.loadPets("dog")
            "2" -> viewModel.loadPets("cat")
        }

        setContent {

            AppNavigation(
                viewModel = viewModel,
                finishActivity = {
                    finish()
                }
            )

        }
    }
}