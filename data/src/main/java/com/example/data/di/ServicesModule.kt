package com.example.data.di

import com.example.data.service.RetrofitFactory
import com.example.data.service.RevolutService
import dagger.Module
import dagger.Provides

@Module(includes = [MappersModule::class])
internal class ServicesModule {

    @Provides
    fun providesRevolutService(): RevolutService {
        return RetrofitFactory.getService(RevolutService::class.java)
    }
}