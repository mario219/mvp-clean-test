package com.example.mvp_test.mvp.home

import android.annotation.SuppressLint
import android.util.Log
import com.example.domain.constants.CURRENCY_FETCHED
import com.example.domain.constants.REVOLUT
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class HomePresenter @Inject constructor(
    private val model: HomeContract.HomeModel,
    private val view: HomeContract.HomeView
): HomeContract.HomePresenter {

    private lateinit var intervalHandler: Disposable

    override fun initCurrencyObserver() {
        intervalHandler = Observable
            .interval(0, 1, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ callService() }, { error -> Log.d(REVOLUT, error.toString()) })
    }

    override fun onPause() {
        if (::intervalHandler.isInitialized && !intervalHandler.isDisposed)
            intervalHandler.dispose()
    }

    @SuppressLint("CheckResult")
    private fun callService() {
        model.fetchCurrencies()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { baseRate ->
                    Log.d(REVOLUT, CURRENCY_FETCHED) },
                { error ->
                    Log.e(REVOLUT, error.toString())
                })
    }
}