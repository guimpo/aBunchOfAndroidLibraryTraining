package com.guimpo.dagger2training.dagger

import android.app.Application
import com.guimpo.dagger2training.MainActivity
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(main: MainActivity)
}