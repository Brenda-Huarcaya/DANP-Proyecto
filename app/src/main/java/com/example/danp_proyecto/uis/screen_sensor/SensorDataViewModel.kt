package com.example.danp_proyecto.uis.screen_sensor

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.danp_proyecto.MQTT.Client
import com.himanshoe.charty.line.model.LineData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SensorDataViewModel @Inject constructor(
    private val clientMQTT: Client
) : ViewModel() {
    //LINEDATA PUNTO EN EL PLANO (X,Y)
    private val _dataList = mutableStateListOf(LineData(0f, "00:00"))
    val dataList: List<LineData> get() = _dataList

    private val _datito = MutableLiveData<String>()
    val datito: LiveData<String> = _datito


    fun subscribeTopicSensor() {
        if (clientMQTT.isConnected()) {
            clientMQTT.subscribe("outTopic", 0) { data ->
                /*
                val aux = data.toFloat()
                determinarDatitos(aux)
*/
                if (data != null) {
                    _dataList.add(LineData(data.toFloat(), "10"))
                    //determinarDatitos(aux)
                    if (_dataList.size >= 8) {
                        _dataList.removeAt(1)
                    }
                }
            }
        }
    }

    fun determinarDatitos(datoSensor: Float) {
        println("datosensor: " + datoSensor)
        if (datoSensor < 500){
            _datito.value = "PELIGRO"
        }
        else{
            _datito.value = "NORMAL"
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