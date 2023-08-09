package com.example.danp_proyecto.MQTT

import org.eclipse.paho.client.mqttv3.MqttException
import org.eclipse.paho.client.mqttv3.MqttMessage
import java.nio.charset.StandardCharsets
import javax.inject.Inject

//SE USA INJECCION PARA EVITAR INSTANCIAR EL PROVIDER EN LA CLASE
class Client @Inject constructor ( private val mqttCP: ClientProviderInt )
{
    //private var client: MqttClient? = null
    private var client = mqttCP.provideMqttClient()

    fun connect() {
        try {
            client.connect()
        } catch (e: MqttException) {
            e.printStackTrace()
        }
    }

    fun isConnected(): Boolean{
        return client.isConnected
    }

    fun disconnect() {
        try {
            client.disconnect()
        } catch (e: MqttException) {
            e.printStackTrace()
        }
    }

    fun publish(topic: String, message: String) {
        try {
            val mqttMessage = MqttMessage(message.toByteArray())
            //PAHO PUBLISH
            client.publish(topic, mqttMessage)
        } catch (e: MqttException) {
            e.printStackTrace()
        }
    }

    fun subscribe(topic: String, qos: Int, onDataReceived: (String) -> Unit) {
        try {
            //PAHO SUBSCRIBE
            client.subscribe(topic, qos) { _, message ->
                val data = message.payload.toString(StandardCharsets.UTF_8)
                onDataReceived(data)
            }
        } catch (e: MqttException) {
            e.printStackTrace()
        }
    }

    fun unsubscribe(topic: String) {
        try {
            client.unsubscribe(topic)
        } catch (e: MqttException) {
            e.printStackTrace()
        }
    }
}