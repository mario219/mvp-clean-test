package com.example.mvp_test.di

import android.content.Context
import com.example.mvp_test.CurrencyApp
import dagger.Module

@Module(includes = [ApplicationInjectorsModule::class])
abstract class ApplicationModule {

    internal abstract fun providesContext(application: CurrencyApp): Context
}