package com.example.mvp_test.mvp.home

import com.example.domain.model.BaseRates
import io.reactivex.Single

interface HomeContract {

    interface HomeView

    interface HomePresenter {
        fun init()
    }

    interface HomeModel {
        fun fetchCurrencies(): Single<BaseRates>
        fun getCachedCurrienciesIfRequired(): Single<BaseRates>
    }
}