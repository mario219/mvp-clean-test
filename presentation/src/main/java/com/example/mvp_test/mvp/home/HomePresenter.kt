package com.example.mvp_test.mvp.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
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

    override fun initCurrencyObserver(baseRate: String) {
        intervalHandler = Observable
            .interval(0, 1, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ callService(baseRate) }, { error -> Log.d(REVOLUT, error.toString()) })
    }

    override fun setOnTapCurrencyListener() {
        view.setOnTapCurrencyListener { baseRate ->
            if (!intervalHandler.isDisposed)
                intervalHandler.dispose()
            initCurrencyObserver(baseRate)
        }
    }

    override fun onPause() {
        if (::intervalHandler.isInitialized && !intervalHandler.isDisposed)
            intervalHandler.dispose()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        // view.onRestoreInstanceState(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        // view.onSaveInstanceState(outState)
    }

    @SuppressLint("CheckResult")
    private fun callService(baseRate: String) {
        model.fetchCurrencies(baseRate)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { baseRate ->
                    Log.d(REVOLUT, "fetched")
//                    view.saveInstanceState()
//                    view.fillRecycler(baseRate)
                },
                { error -> Log.e(REVOLUT, error.toString()) })
    }
}