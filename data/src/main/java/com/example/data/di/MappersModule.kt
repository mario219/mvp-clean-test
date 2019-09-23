package com.example.data.di

import com.example.data.mappers.BaseMapper
import com.example.data.mappers.BaseRemoteMapper
import com.example.data.mappers.CurrencyLocalMapper
import com.example.data.mappers.CurrencyRemoteMapper
import com.example.data.model.cache.BaseRatesLocal
import com.example.data.model.remote.BaseRatesRemote
import com.example.domain.model.BaseRates
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
internal abstract class MappersModule {

    @Binds
    @Reusable
    abstract fun providesCurrencyLocalMapper(currencyLocalMapper: CurrencyLocalMapper): BaseMapper<BaseRatesLocal, BaseRates>

    @Binds
    @Reusable
    abstract fun providesCurrecyRemoteMapper(currencyRemoteMapper: CurrencyRemoteMapper): BaseRemoteMapper<BaseRatesRemote, BaseRates>
}