package com.example.mvp_test.mvp.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.domain.constants.BASE_RATE
import com.example.domain.constants.ONE_DOUBLE
import com.example.domain.constants.REVOLUT
import com.example.mvp_test.model.CurrencyDataModel
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
    private var baseRate = BASE_RATE
    var baseRateLD = MutableLiveData<CurrencyDataModel>().apply { value = CurrencyDataModel(BASE_RATE, ONE_DOUBLE) }

    override fun initView() {
        view.init()
    }

    override fun initCurrencyObserver() {
        initCurrencyObserver(baseRate)
    }

    override fun initCurrencyObserver(baseRate: String) {
        this.baseRate = baseRate
        baseRateLD.value = CurrencyDataModel(baseRate, ONE_DOUBLE)
        intervalHandler = Observable
            .interval(0, 1, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ callService(baseRate) }, { error -> Log.d(REVOLUT, error.toString()) })
    }

    override fun setOnTapCurrencyListener() {
        view.setOnTapCurrencyListener { baseRate ->
            if (!intervalHandler.isDisposed)
                intervalHandler.dispose()
            view.scrollRecyclerToTop()
            initCurrencyObserver(baseRate)
        }
    }

    override fun onPause() {
        if (::intervalHandler.isInitialized && !intervalHandler.isDisposed)
            intervalHandler.dispose()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        view.onRestoreInstanceState(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        view.onSaveInstanceState(outState)
    }

    @SuppressLint("CheckResult")
    private fun callService(baseRate: String) {
        model.fetchCurrencies(baseRate)
            .map { baseRates ->
                baseRates.rates.remove(baseRate)
                val finalMap = mutableMapOf<String, Double>()
                finalMap[baseRate] = ONE_DOUBLE
                baseRates.rates.forEach {
                    finalMap[it.key] = it.value
                }
                finalMap.remove(baseRate)
                finalMap
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { ratesResults ->
                    view.saveInstanceState()
                    view.fillRecycler(ratesResults)
                },
                { error -> Log.e(REVOLUT, error.toString()) })
    }
}