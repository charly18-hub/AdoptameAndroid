package com.example.adoptame.utils
import com.example.adoptame.Modal.ModalAdoptados
import com.example.adoptame.R

class GetDataClass {

    fun getDogList(): List<ModalAdoptados> {
        return listOf(
            ModalAdoptados("Guera", R.drawable.pet,"2 meses", "Mix Chihuahua","Enviar Solicitud"),
            ModalAdoptados("Spike", R.drawable.pet, "4 Años", "Beagle","Enviar Solicitud"),
            ModalAdoptados("Chocolata", R.drawable.pet,"6 Meses","Mix Pastor","Enviar Solicitud"),
            ModalAdoptados("Chaparra", R.drawable.pet,"8 meses", "Mix Beagle","Enviar Solicitud")
        )
    }

    fun getCatList(): List<ModalAdoptados> {
        return listOf(
            ModalAdoptados("Guera", R.drawable.cat1,"2 meses", "Mix Chihuahua","Enviar Solicitud"),
            ModalAdoptados("Spike", R.drawable.cat1, "4 Años", "Beagle","Enviar Solicitud"),
            ModalAdoptados("Chocolata", R.drawable.cat1,"6 Meses","Mix Pastor","Enviar Solicitud"),
            ModalAdoptados("Chaparra", R.drawable.cat1,"8 meses", "Mix Beagle","Enviar Solicitud")
        )
    }
}