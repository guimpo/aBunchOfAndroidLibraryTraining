package com.guimpo.dagger2training.dagger

import com.guimpo.dagger2training.App
import dagger.Module
import dagger.Provides

@Module
class AppModule(var app: App) {

    @Provides
    fun providesApp(): App = app

}
