package com.guimpo.dagger2training.dagger

import com.guimpo.dagger2training.domain.entity.User
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideUser(): User = User()

}
