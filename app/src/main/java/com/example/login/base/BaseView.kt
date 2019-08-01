package com.example.login.base

interface BaseView <out T: BasePresenter<*>> {
    val presenter:T
}