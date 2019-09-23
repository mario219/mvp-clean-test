package com.example.data.di

import com.example.data.datasource.CurrencyLocalDataSourceImpl
import com.example.data.datasource.CurrencyRemoteDataSourceImpl
import com.example.domain.datasource.CurrencyLocalDataSource
import com.example.domain.datasource.CurrencyRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module(includes = [ServicesModule::class, MappersModule::class])
internal abstract class DataSourceModule {

    @Binds
    @Reusable
    abstract fun providesCurrencyLocalDataSource(currencyLocalDataSourceImpl: CurrencyLocalDataSourceImpl): CurrencyLocalDataSource

    @Binds
    @Reusable
    abstract fun providesCurrencyRemoteDataSource(currencyRemoteDataSourceImpl: CurrencyRemoteDataSourceImpl): CurrencyRemoteDataSource
}