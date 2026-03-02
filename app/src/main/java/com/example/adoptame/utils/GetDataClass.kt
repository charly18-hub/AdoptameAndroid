package com.example.adoptame.utils
import com.example.adoptame.Modal.ModalAdoptados
import com.example.adoptame.Modal.ModalAsociacion
import com.example.adoptame.Modal.ModalEventos
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

    fun getAsociacionesData(): List<ModalAsociacion>{
        return listOf(
            ModalAsociacion(
                name = "Adopta Huellitas",
                city = "Monterrey",
                dogs = 34,
                cats = 12,
                logo = R.drawable.adopta_huellitas,
                verified = true
            ),
            ModalAsociacion(
                name = "Patitas de Amor",
                city = "CDMX",
                dogs = 10,
                cats = 8,
                logo = R.drawable.patitas_amor,
                verified = false
            )
        )
    }

    fun getEventosData(): List<ModalEventos>{
        return listOf(
            ModalEventos(
                nameEvento = "Adopta Huellitas",
                location = "Parque Fundidora",
                date = "Sáb 19 Feb · 11:00 am",
                pets = "12",
                courseImg = R.drawable.adopta_huellitas,
            ),
            ModalEventos(
                nameEvento = "Adopta Huellitas",
                location = "Parque Mexico",
                date = "Sáb 6 Feb · 11:00 am",
                pets = "12",
                courseImg = R.drawable.adopta_huellitas,
            )
        )
    }

}