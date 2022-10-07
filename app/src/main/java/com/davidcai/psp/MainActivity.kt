package com.davidcai.psp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.davidcai.psp.ut02.ex01.data.remote.RetrofitApiClient


class MainActivity : AppCompatActivity() {

    val apiClient = RetrofitApiClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Thread{
            val users = apiClient.getUsers()
            Log.d("@dev","usuarios: $users")
        }.start()

    }
}
