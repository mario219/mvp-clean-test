package com.example.mvp_test.di

import com.example.data.di.RepositoryModule
import com.example.mvp_test.mvp.home.HomeContract
import com.example.mvp_test.mvp.home.HomeModel
import com.example.mvp_test.mvp.home.HomePresenter
import com.example.mvp_test.mvp.home.HomeView
import dagger.Binds
import dagger.Module

@Module(includes = [RepositoryModule::class])
abstract class CurrencyModule {

    @Binds
    abstract fun providesHomeView(homeView: HomeView): HomeContract.HomeView

    @Binds
    abstract fun providesHomePresenter(homePresenter: HomePresenter): HomeContract.HomePresenter

    @Binds
    abstract fun providesHomeModel(homeModel: HomeModel): HomeContract.HomeModel
}