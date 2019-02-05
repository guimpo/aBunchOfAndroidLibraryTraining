package com.guimpo.dagger2training

import android.app.Application
import com.guimpo.dagger2training.dagger.AppComponent
import com.guimpo.dagger2training.dagger.AppModule
import com.guimpo.dagger2training.dagger.DaggerAppComponent

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