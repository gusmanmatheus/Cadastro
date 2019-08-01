package com.example.login.base.modules

import com.example.login.data.remote.ServiceRequest
import com.example.login.feature.register.RegisterContract
import com.example.login.feature.register.RegisterPresenter
import org.koin.dsl.bind
import org.koin.dsl.module

val regisModule = module{
    factory { ServiceRequest() }
    factory { (view: RegisterContract.View) ->
        RegisterPresenter(
            view = view,
            service = get()
        )
    }bind RegisterPresenter::class
}