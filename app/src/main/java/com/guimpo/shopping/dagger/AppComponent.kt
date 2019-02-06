package com.guimpo.shopping.dagger

import com.guimpo.shopping.presentation.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(main: MainActivity)
}