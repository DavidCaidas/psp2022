package com.davidcai.psp.ut02.ex01.data.remote

import com.davidcai.psp.ut02.ex01.data.remote.models.UserApiModel
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

    fun getUser(userId: Int): UserApiModel?{
        val userCall = apiEndPoints.getUsers(userId)
        val response = userCall.execute()

        if (response.isSuccessful){
            val users = response.body()
            return users ?: emptyList<UserApiModel>()
        } else{
            return emptyList<UserApiModel>()
        }
    }


}
