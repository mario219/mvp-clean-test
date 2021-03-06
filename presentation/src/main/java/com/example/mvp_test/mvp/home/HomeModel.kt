package com.example.mvp_test.mvp.home

import com.example.domain.model.BaseRates
import com.example.domain.usecase.GetCurrencyUseCase
import io.reactivex.Single
import javax.inject.Inject

class HomeModel @Inject constructor(private val getCurrencyUseCase: GetCurrencyUseCase) : HomeContract.HomeModel {

    override fun fetchCurrencies(baseRate: String): Single<BaseRates> =
        getCurrencyUseCase.getCurrency(baseRate)

    override fun getCachedCurrienciesIfRequired(): Single<BaseRates> =
        getCurrencyUseCase.getCachedCurrency()
}