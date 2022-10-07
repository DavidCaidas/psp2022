package com.davidcai.psp.ut02.ex02.data.repository.remoteSource.models

import com.davidcai.psp.ut02.ex01.data.remote.models.AlertApiModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndPoints {
    @GET("alerts")
fun getAlerts(alertId: Int): Call<List<AlertApiModel>>

    @GET("alerts/{alertId}")
fun getAlert (@Path("alertId") alertId:Int): Call<AlertApiModel>
}