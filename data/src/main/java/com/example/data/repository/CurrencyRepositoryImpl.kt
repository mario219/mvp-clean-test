package com.example.data.repository

import com.example.domain.datasource.CurrencyLocalDataSource
import com.example.domain.datasource.CurrencyRemoteDataSource
import com.example.domain.model.BaseRates
import com.example.domain.repository.CurrencyRepository
import io.reactivex.Single
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(
    private val currencyLocalDataSource: CurrencyLocalDataSource,
    private val currencyRemoteDataSource: CurrencyRemoteDataSource
) : CurrencyRepository {

    override fun getCurrency(baseRate: String): Single<BaseRates> =
        currencyRemoteDataSource.getCurrency(baseRate).flatMap { baseRates ->
            currencyLocalDataSource.saveCurrency(baseRates).andThen(Single.just(baseRates))
        }

    override fun getCachedCurrency(): Single<BaseRates> =
        currencyLocalDataSource.getCurrency()
}