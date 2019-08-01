package com.example.login.data.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.xml.datatype.DatatypeConstants.SECONDS

class ServiceProvider {
    companion object {
         val client = OkHttpClient()
        .newBuilder()
        .callTimeout(20, TimeUnit.SECONDS)
        .build()


        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://trancosowiliam.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        val request = retrofit.create(ApiService::class.java)


    }

}