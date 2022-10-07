package com.davidcai.psp.ut02.ex02.data.repository.remoteSource.models

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApiClient {

    private val urlEndPoint = "https://jsonplaceholder.typicode.com/"
    private var apiEndPoints: ApiEndPoints
    init {
        apiEndPoints = buildApiEndPoints()
    }

    private fun buildClient(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(urlEndPoint)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun buildApiEndPoints(): ApiEndPoints {
        return buildClient().create(ApiEndPoints::class.java)
    }

    fun getAlert(alertId: Int): AlertApiModel?{
        val alertCall = apiEndPoints.getAlerts(alertId)
        val response = alertCall.execute()

        if (response.isSuccessful){
            val alerts = response.body()
            return alerts ?: emptyList<AlertApiModel>()
        } else{
            return emptyList<AlertApiModel>()
        }
    }


}