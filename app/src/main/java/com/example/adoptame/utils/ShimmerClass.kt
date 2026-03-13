package com.example.adoptame.utils

import androidx.recyclerview.widget.RecyclerView
import com.example.adoptame.adapter.RecyclerAdapterAdoptados
import com.example.adoptame.adapter.RecyclerAdapterAsociacion
import com.example.adoptame.adapter.RecyclerAdapterEventos

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