package com.example.adoptame.utils

import android.content.Context
import android.os.Handler
import androidx.recyclerview.widget.GridLayoutManager
import com.example.adoptame.Adapter.RecyclerAdapterAdoptados
import com.example.adoptame.Modal.ModalAdoptados
import com.example.adoptame.R

class getSpecieUtils {

    fun getSpecie(context: Context): String? {
        val sharedPreferences =
            context.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        return sharedPreferences.getString("especieType", "")
    }

}