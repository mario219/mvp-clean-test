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
            eur = rates["eur"] ?: ONE_DOUBLE
            aud = rates["aud"] ?: ONE_DOUBLE
            bgn = rates["bgn"] ?: ONE_DOUBLE
            brl = rates["brl"] ?: ONE_DOUBLE
            cad = rates["cad"] ?: ONE_DOUBLE
            chf = rates["chf"] ?: ONE_DOUBLE
            cny = rates["cny"] ?: ONE_DOUBLE
            czk = rates["czk"] ?: ONE_DOUBLE
            dkk = rates["dkk"] ?: ONE_DOUBLE
            gbp = rates["gbp"] ?: ONE_DOUBLE
            hkd = rates["hkd"] ?: ONE_DOUBLE
            hrk = rates["hrk"] ?: ONE_DOUBLE
            huf = rates["huf"] ?: ONE_DOUBLE
            idr = rates["idr"] ?: ONE_DOUBLE
            ils = rates["ils"] ?: ONE_DOUBLE
            inr = rates["inr"] ?: ONE_DOUBLE
            isk = rates["isk"] ?: ONE_DOUBLE
            jpy = rates["jpy"] ?: ONE_DOUBLE
            krw = rates["krw"] ?: ONE_DOUBLE
            mxn = rates["mxn"] ?: ONE_DOUBLE
            myr = rates["myr"] ?: ONE_DOUBLE
            nok = rates["nok"] ?: ONE_DOUBLE
            nzd = rates["nzd"] ?: ONE_DOUBLE
            php = rates["php"] ?: ONE_DOUBLE
            pln = rates["pln"] ?: ONE_DOUBLE
            ron = rates["ron"] ?: ONE_DOUBLE
            rub = rates["rub"] ?: ONE_DOUBLE
            sek = rates["sek"] ?: ONE_DOUBLE
            sgd = rates["sgd"] ?: ONE_DOUBLE
            thb = rates["thb"] ?: ONE_DOUBLE
            tryy = rates["tryy"] ?: ONE_DOUBLE
            usd = rates["usd"] ?: ONE_DOUBLE
            zar = rates["zar"] ?: ONE_DOUBLE
        }
    }
}