package com.example.data.mappers

import com.example.data.model.remote.BaseRatesRemote
import com.example.domain.model.BaseRates
import javax.inject.Inject

internal class CurrencyRemoteMapper @Inject constructor() : BaseRemoteMapper<BaseRatesRemote, BaseRates>, MapperUtils() {

    override fun transform(input: BaseRatesRemote) =
        BaseRates().apply {
            base = input.base
            date = input.date
            rates = input.rates.serializeToMap()
        }
}