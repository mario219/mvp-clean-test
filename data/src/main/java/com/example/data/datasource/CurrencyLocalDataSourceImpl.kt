package com.example.data.datasource

import com.example.data.mappers.CurrencyLocalMapper
import com.example.data.model.cache.BaseRatesLocal
import com.example.domain.datasource.CurrencyLocalDataSource
import com.example.domain.model.BaseRates
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

internal class CurrencyLocalDataSourceImpl @Inject constructor(
    private val mapper: CurrencyLocalMapper
) : RealmDataSource<BaseRatesLocal>(BaseRatesLocal::class.java), CurrencyLocalDataSource {

    override fun saveCurrency(baseRates: BaseRates): Completable {
        return Completable.fromAction {
            saveRates(mapper.transform(baseRates))
        }
    }

    override fun getCurrency(): Single<BaseRates> {
        return Single.fromCallable {
            getRates().first()?.let {
                return@fromCallable mapper.transform(it)
            }
        }
    }
}