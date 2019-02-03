package com.guimpo.dagger2training.dagger

import com.guimpo.dagger2training.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(main: MainActivity)
}