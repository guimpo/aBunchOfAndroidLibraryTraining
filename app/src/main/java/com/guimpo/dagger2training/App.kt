package com.guimpo.dagger2training

import android.app.Activity
import android.app.Application
import com.guimpo.dagger2training.dagger.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

//    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        initDagger()
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }

    private fun initDagger() {
//        component = DaggerAppComponent.builder()
//            .application(this)
//            .build()

    }

    override fun activityInjector(): AndroidInjector<Activity> = activityDispatchingAndroidInjector
}