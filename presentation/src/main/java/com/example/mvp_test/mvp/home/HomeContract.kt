package com.example.mvp_test.mvp.home

import android.os.Bundle
import com.example.domain.model.BaseRates
import io.reactivex.Single

interface HomeContract {

    interface HomeView {
        fun init()
        fun fillRecycler(baseRates: MutableMap<String, Double>)
        fun setOnTapCurrencyListener(listener: (baseRate: String) -> Unit)
        fun scrollRecyclerToTop()
        fun setMultiplier(number: Double)
        fun onSaveInstanceState(outState: Bundle?)
        fun onRestoreInstanceState(savedInstanceState: Bundle?)
        fun saveInstanceState()
        fun clearInstanceState()
    }

    interface HomePresenter {
        fun initView()
        fun initCurrencyObserver()
        fun initCurrencyObserver(baseRate: String)
        fun setOnTapCurrencyListener()
        fun setMultiplier(number: Double)
        fun onPause()
        fun onSaveInstanceState(outState: Bundle?)
        fun onRestoreInstanceState(savedInstanceState: Bundle?)
    }

    interface HomeModel {
        fun fetchCurrencies(baseRate: String): Single<BaseRates>
        fun getCachedCurrienciesIfRequired(): Single<BaseRates>
    }
}