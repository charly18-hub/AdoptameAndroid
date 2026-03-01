package com.example.adoptame.utils

import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.example.adoptame.Adapter.RecyclerAdapterAdoptados
import com.example.adoptame.Adapter.RecyclerAdapterAsociacion
import com.example.adoptame.Adapter.RecyclerAdapterEventos

class ShimmerClass {

    fun stopLoadingAsociaciones(adapter: RecyclerView.Adapter<*>){
        if (adapter is RecyclerAdapterAsociacion){
            adapter.isLoading = false
        }
        adapter.notifyDataSetChanged()
    }

    fun stopLoading(adapter: RecyclerView.Adapter<*>) {
        if (adapter is RecyclerAdapterAdoptados) {
            adapter.isLoading = false
        }
        adapter.notifyDataSetChanged()
    }

    fun stopLoadingEventos(adapter: RecyclerView.Adapter<*>){
        if(adapter is RecyclerAdapterEventos){
            adapter.isLoading = false
        }
        adapter.notifyDataSetChanged()
    }
}