package com.example.domain.repository

import com.example.domain.model.BaseRates
import io.reactivex.Single

interface CurrencyRepository {

    fun getCurrency(baseRate: String): Single<BaseRates>
    fun getCachedCurrency(): Single<BaseRates>
}