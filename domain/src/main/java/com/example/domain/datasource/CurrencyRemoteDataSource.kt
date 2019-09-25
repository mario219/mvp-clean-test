package com.example.domain.datasource

import com.example.domain.model.BaseRates
import io.reactivex.Single

interface CurrencyRemoteDataSource {

    fun getCurrency(baseRate: String): Single<BaseRates>
}