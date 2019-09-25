package com.example.data.datasource

import com.example.data.mappers.CurrencyRemoteMapper
import com.example.data.service.RevolutService
import com.example.domain.datasource.CurrencyRemoteDataSource
import com.example.domain.model.BaseRates
import io.reactivex.Single
import javax.inject.Inject

internal class CurrencyRemoteDataSourceImpl @Inject constructor(
    private val revolutService: RevolutService,
    private val mapper: CurrencyRemoteMapper
) : CurrencyRemoteDataSource {

    override fun getCurrency(baseRate: String): Single<BaseRates> {
        return revolutService.getLatests(baseRate)
            .map { baseRate ->
                mapper.transform(baseRate)
            }
    }
}