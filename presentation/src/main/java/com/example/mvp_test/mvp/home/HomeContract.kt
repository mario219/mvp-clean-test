package com.example.mvp_test.mvp.home

import android.os.Bundle
import com.example.domain.model.BaseRates
import io.reactivex.Single

interface HomeContract {

    interface HomeView {
        fun fillRecycler(baseRates: BaseRates)
        fun setOnTapCurrencyListener(listener: (baseRate: String) -> Unit)
        fun onSaveInstanceState(outState: Bundle?)
        fun onRestoreInstanceState(savedInstanceState: Bundle?)
        fun saveInstanceState()
    }

    interface HomePresenter {
        fun initCurrencyObserver(baseRate: String)
        fun setOnTapCurrencyListener()
        fun onPause()
        fun onSaveInstanceState(outState: Bundle?)
        fun onRestoreInstanceState(savedInstanceState: Bundle?)
    }

    interface HomeModel {
        fun fetchCurrencies(baseRate: String): Single<BaseRates>
        fun getCachedCurrienciesIfRequired(): Single<BaseRates>
    }
}