package com.example.domain.datasource

import com.example.domain.model.BaseRates
import io.reactivex.Completable
import io.reactivex.Single

interface CurrencyLocalDataSource {

    fun saveCurrency(baseRates: BaseRates): Completable
    fun getCurrency(): Single<BaseRates>
}