package com.example.login.feature.register

import android.util.Log
import com.example.login.data.model.User
import com.example.login.data.remote.ServiceRequest

class RegisterPresenter(
    override var view: RegisterContract.View,
    val service: ServiceRequest
): RegisterContract.Presenter {


    override fun request(user: User) {
        view.viewLoadingOn()
        service.registerUser(user,
            fun(success){
                if( success != null && success.id != 0) {
                    view.viewLoadingOff()
                    view.dialogResponse(Response.success)
                }else {
                    view.viewLoadingOff()
                    view.dialogResponse(Response.errorServer)
                }
            },
            fun(failure){
                Log.i("test",failure)
                view.viewLoadingOff()
                view.dialogResponse(Response.innerError)
            })
    }
    enum class Response(val value:String) {
        success("Sucesso ao Cadastrar"),
        errorServer("Servidor esta com erro"),
        innerError("Verifique a internet")
    }

}