package com.guimpo.dagger2training.dagger

import com.guimpo.dagger2training.App
import com.guimpo.dagger2training.domain.entity.User
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(var app: App) {

    @Provides
    fun providesApp(): App = app

    @Provides
    @Singleton
    fun provideUser(): User = User()

}
