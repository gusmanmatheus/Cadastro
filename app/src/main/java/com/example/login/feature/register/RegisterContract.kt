package com.example.login.feature.register

import com.example.login.base.BasePresenter
import com.example.login.base.BaseView
import com.example.login.data.model.User

interface RegisterContract {
    interface View: BaseView <Presenter>{
        fun viewLoadingOn()
        fun viewLoadingOff()
        fun dialogResponse(resp: RegisterPresenter.Response)
    }


    interface Presenter: BasePresenter<View> {
        fun request(user: User)
    }
}