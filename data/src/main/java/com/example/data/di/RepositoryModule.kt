package com.example.data.di

import com.example.data.repository.CurrencyRepositoryImpl
import com.example.domain.repository.CurrencyRepository
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module(includes = [DataSourceModule::class])
abstract class RepositoryModule {

    @Binds
    @Reusable
    abstract fun providesCurrencyRepository(currencyRepository: CurrencyRepositoryImpl): CurrencyRepository
}