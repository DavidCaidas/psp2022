package com.davidcai.psp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.davidcai.psp.ut02.data.remote.RetroFitApiClient
import com.davidcai.psp.ut02.data.remote.models.UsersApiModel

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiClient=RetroFitApiClient()

        Thread{
            val users =apiClient.getUsers()
            Log.d("@dev","usuarios: $users")
        }.start()


        Thread{
            val user = apiClient.getUser(1)
            Log.d("@dev", "Usuario $user")
        }.start()

    }
}



