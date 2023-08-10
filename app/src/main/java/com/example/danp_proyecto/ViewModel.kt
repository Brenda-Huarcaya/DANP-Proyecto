package com.example.danp_proyecto

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.danp_proyecto.MQTT.Client
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor( private val clientMQTT: Client) : ViewModel()
{
    private val _dataList = mutableStateListOf<String>()
    val dataList: List<String> get() = _dataList

    fun publishMessage(topic: String, message: String) {
        if (clientMQTT.isConnected()) {
            clientMQTT.publish(topic, message)
        }
    }
    override fun onCleared() {
        super.onCleared()
        // Eliminar la suscripción cuando el ViewModel sea destruido
        val topic = "outTopic"
        if (clientMQTT.isConnected()) {
            println("PASO POR LA UNSUBSCRIBE")
            clientMQTT.unsubscribe(topic)
        }
    }
}