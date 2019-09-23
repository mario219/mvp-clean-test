package com.example.mvp_test.mvp.home

import android.util.Log
import com.example.domain.constants.CURRENCY_FETCHED
import com.example.domain.constants.REVOLUT
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class HomePresenter @Inject constructor(
    private val model: HomeContract.HomeModel,
    private val view: HomeContract.HomeView
): HomeContract.HomePresenter {

    private val subscriptions = CompositeDisposable()

    override fun initCurrencyObserver() {
        val currencyDisposable = model.fetchCurrencies()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { baseRate ->
                    Log.d(REVOLUT, CURRENCY_FETCHED) },
                { error ->
                    Log.e(REVOLUT, error.message)
                })
        subscriptions.add(currencyDisposable)
    }

    override fun onPause() {
        subscriptions.dispose()
    }
}