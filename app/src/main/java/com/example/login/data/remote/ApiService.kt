package com.example.login.data.remote

import com.example.login.data.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiService {

    @POST("usuario")
    fun registerUser(@Body user: User): Call<User>
}