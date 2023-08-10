package com.example.danp_proyecto.uis.screen_sensor

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.danp_proyecto.MQTT.Client
import com.himanshoe.charty.line.model.LineData
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class SensorDataViewModel @Inject constructor(
    private val clientMQTT: Client
) : ViewModel() {
    //LINEDATA PUNTO EN EL PLANO (X,Y)
    private val _dataList = mutableStateListOf(LineData(0f, "00:00"))
    val dataList: List<LineData> get() = _dataList

    private val _datitoUltimo = MutableLiveData<Float>()
    val datitoUltimo: LiveData<Float> = _datitoUltimo

    fun subscribeTopicSensor() {
        if (clientMQTT.isConnected()) {
            clientMQTT.subscribe("outTopic", 0) { data ->

                val datoDatitoUltimo = data.toFloat()
                _datitoUltimo.postValue(datoDatitoUltimo)

                if (data != null) {

                    val currentTime = Calendar.getInstance()
                    val hour = currentTime.get(Calendar.HOUR_OF_DAY)
                    val minute = currentTime.get(Calendar.MINUTE)
                    val formattedTime = String.format("%02d:%02d", hour, minute)

                    _dataList.add(LineData(data.toFloat(), formattedTime))

                    if (_dataList.size >= 7) {
                        _dataList.removeAt(1)
                    }

                }
            }
        }
    }

    fun publishMessage(topic: String, message: String) {
        if (clientMQTT.isConnected()) {
            clientMQTT.publish(topic, message)
        }
    }

    override fun onCleared() {
        // Eliminar la suscripción cuando el ViewModel sea destruido
        val topic = "outTopic"
        if (clientMQTT.isConnected()) {
            clientMQTT.unsubscribe(topic)
        }
        super.onCleared()
    }

}