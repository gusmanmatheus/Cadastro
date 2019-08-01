package com.example.login.base

import android.app.Application
import com.example.login.base.modules.regisModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
@Suppress("unused")
class App: Application() {
    private val modules = listOf(
        regisModule
    )
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(modules)
        }
    }
}