package com.example.mvp_test.di

import com.example.mvp_test.mvp.activity.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityInjectorModule {

    @ContributesAndroidInjector(modules = [CurrencyModule::class])
    abstract fun homeActivity(): HomeActivity
}