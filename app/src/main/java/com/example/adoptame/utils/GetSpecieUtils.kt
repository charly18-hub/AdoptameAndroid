package com.example.adoptame.utils

import android.content.Context

class GetSpecieUtils {

    fun getSpecie(context: Context): String? {
        val sharedPreferences =
            context.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        return sharedPreferences.getString("especieType", "")
    }

}