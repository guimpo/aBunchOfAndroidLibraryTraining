package com.guimpo.dagger2training.dagger

import com.guimpo.dagger2training.presentation.MainActivity
import com.guimpo.dagger2training.presentation.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity
}