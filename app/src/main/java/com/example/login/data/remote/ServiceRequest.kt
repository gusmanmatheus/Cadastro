package com.example.login.data.remote

import com.example.login.data.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ServiceRequest {
    fun registerUser(
        user: User,
        success:(user:User?)->Unit,
        failure:(error:String)->Unit){
        ServiceProvider.request.registerUser(user)
            .enqueue(object: Callback<User> {
                override fun onFailure(call: Call<User>, t: Throwable) {
                    failure(t.message.toString())
                }
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    response.body().let(success)
                }

            })
    }
}