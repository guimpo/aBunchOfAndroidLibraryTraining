package com.guimpo.shopping

import android.app.Application
import com.guimpo.shopping.dagger.AppComponent
import com.guimpo.shopping.dagger.AppModule
import com.guimpo.shopping.dagger.DaggerAppComponent

class App : Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        component = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}