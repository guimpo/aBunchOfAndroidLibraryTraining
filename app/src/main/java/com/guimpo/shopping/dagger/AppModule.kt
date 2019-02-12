package com.guimpo.shopping.dagger

import com.guimpo.shopping.domain.entity.User
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideUser(): User = User()

}
