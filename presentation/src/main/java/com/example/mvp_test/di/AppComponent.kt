package com.example.mvp_test.di

import com.example.mvp_test.CurrencyApp
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, AndroidInjectionModule::class])
interface AppComponent : AndroidInjector<CurrencyApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<CurrencyApp>()
}