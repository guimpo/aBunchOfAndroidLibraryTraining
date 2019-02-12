package com.guimpo.dagger2training.presentation

import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {
    @Provides
    fun provideString() = "provided by MainActivityModule XD"
}