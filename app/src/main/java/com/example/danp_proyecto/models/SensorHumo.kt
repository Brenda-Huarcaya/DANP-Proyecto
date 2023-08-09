package com.example.danp_proyecto.models

import com.google.gson.Gson

data class SensorHumo(val value: Float){
    companion object {
        fun fromJson(json: String): SensorHumo? {
            return try{
                val gson = Gson()
                gson.fromJson(json, SensorHumo::class.java)
            } catch (e: Exception){
                e.printStackTrace()
                null
            }
        }
    }
}