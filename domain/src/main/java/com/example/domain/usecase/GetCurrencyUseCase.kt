package com.example.domain.usecase

import com.example.domain.model.BaseRates
import com.example.domain.repository.CurrencyRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GetCurrencyUseCase @Inject constructor(private val currencyRepository: CurrencyRepository) {

    fun getCurrency(baseRate: String): Single<BaseRates> =
        currencyRepository.getCurrency(baseRate).subscribeOn(Schedulers.newThread())

    fun getCachedCurrency(): Single<BaseRates> =
        currencyRepository.getCachedCurrency().subscribeOn(Schedulers.io())
}