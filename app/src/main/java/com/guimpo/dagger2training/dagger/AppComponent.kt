package com.guimpo.dagger2training.dagger

import com.guimpo.dagger2training.presentation.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(main: MainActivity)
}