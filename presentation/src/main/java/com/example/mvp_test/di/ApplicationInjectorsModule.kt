package com.example.mvp_test.di

import dagger.Module

@Module(includes = [ActivityInjectorModule::class, CurrencyModule::class])
abstract class ApplicationInjectorsModule