package com.guimpo.shopping.dagger

import com.guimpo.shopping.App
import com.guimpo.shopping.domain.entity.User
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
