package com.example.danp_proyecto.MQTT

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//MODULO SERA INSTALADO EN EL COMPONENTE "SINGLETON"
@InstallIn(SingletonComponent::class)

//MQTTObject ES MODULO DE DAGGER
@Module
object Modulo {
    @Provides
    //SE COMPARTIRA EN TODA LA APP
    @Singleton
    //PROVEEDOR DE DEPENDENCIAS
    fun provideMqttClientProvider(@ApplicationContext appContext: Context): ClientProviderInt {
        return ClientProvider(appContext)
    }
}