package com.example.mvp_test.mvp.home

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class HomePresenter @Inject constructor(
    private val model: HomeContract.HomeModel,
    private val view: HomeContract.HomeView
): HomeContract.HomePresenter {

    private val subscriptions = CompositeDisposable()

    override fun init() {
        val currencyDisposable = model.fetchCurrencies()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { baseRate ->
                    Log.d("REVOLUT: ","revolut currency fetched")},
                { error ->
                    Log.e("REVOLUT: ", error.message)
                })
        subscriptions.add(currencyDisposable)
    }
}