package com.example.data.mappers

import com.example.data.model.cache.BaseRatesLocal
import com.example.data.model.cache.RatesLocal
import com.example.domain.constants.ONE_DOUBLE
import com.example.domain.model.BaseRates
import javax.inject.Inject

internal class CurrencyLocalMapper @Inject constructor() : BaseMapper<BaseRatesLocal, BaseRates>, MapperUtils() {

    override fun transform(input: BaseRatesLocal): BaseRates {
        return BaseRates().apply {
            base = input.base
            date = input.date
            rates = input.rates.convert()
        }
    }

    override fun transform(input: BaseRates): BaseRatesLocal {
        return BaseRatesLocal().apply {
            base = input.base
            date = input.date
            rates = mapRates(input.rates)
        }
    }

    private fun mapRates(rates: Map<String, Double>): RatesLocal {
        return RatesLocal().apply {
            eur = rates["EUR"] ?: ONE_DOUBLE
            aud = rates["AUD"] ?: ONE_DOUBLE
            bgn = rates["BGN"] ?: ONE_DOUBLE
            brl = rates["BRL"] ?: ONE_DOUBLE
            cad = rates["CAD"] ?: ONE_DOUBLE
            chf = rates["CHF"] ?: ONE_DOUBLE
            cny = rates["CNY"] ?: ONE_DOUBLE
            czk = rates["CZK"] ?: ONE_DOUBLE
            dkk = rates["DKK"] ?: ONE_DOUBLE
            gbp = rates["GBP"] ?: ONE_DOUBLE
            hkd = rates["HKD"] ?: ONE_DOUBLE
            hrk = rates["HRK"] ?: ONE_DOUBLE
            huf = rates["HUF"] ?: ONE_DOUBLE
            idr = rates["IDR"] ?: ONE_DOUBLE
            ils = rates["ILS"] ?: ONE_DOUBLE
            inr = rates["INR"] ?: ONE_DOUBLE
            isk = rates["ISK"] ?: ONE_DOUBLE
            jpy = rates["JPY"] ?: ONE_DOUBLE
            krw = rates["KRW"] ?: ONE_DOUBLE
            mxn = rates["MXN"] ?: ONE_DOUBLE
            myr = rates["MYR"] ?: ONE_DOUBLE
            nok = rates["NOK"] ?: ONE_DOUBLE
            nzd = rates["NZD"] ?: ONE_DOUBLE
            php = rates["PHP"] ?: ONE_DOUBLE
            pln = rates["PLN"] ?: ONE_DOUBLE
            ron = rates["RON"] ?: ONE_DOUBLE
            rub = rates["RUB"] ?: ONE_DOUBLE
            sek = rates["SEK"] ?: ONE_DOUBLE
            sgd = rates["SGD"] ?: ONE_DOUBLE
            thb = rates["THB"] ?: ONE_DOUBLE
            tryy = rates["TRY"] ?: ONE_DOUBLE
            usd = rates["USD"] ?: ONE_DOUBLE
            zar = rates["ZAR"] ?: ONE_DOUBLE
        }
    }
}