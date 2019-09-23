package com.example.data.mappers

import com.example.data.model.cache.BaseRatesLocal
import com.example.data.model.cache.RatesLocal
import com.example.domain.model.BaseRates
import com.example.domain.model.Rates
import javax.inject.Inject

internal class CurrencyLocalMapper @Inject constructor() : BaseMapper<BaseRatesLocal, BaseRates> {

    override fun transform(input: BaseRatesLocal): BaseRates {
        return BaseRates().apply {
            base = input.base
            date = input.date
            rates = mapLocalRates(input.rates!!)
        }
    }

    override fun transform(input: BaseRates): BaseRatesLocal {
        return BaseRatesLocal().apply {
            base = input.base
            date = input.date
            rates = mapRates(input.rates)
        }
    }

    private fun mapRates(rates: Rates): RatesLocal {
        return RatesLocal().apply {
            aud = rates.aud
            bgn = rates.bgn
            brl = rates.brl
            cad = rates.cad
            chf = rates.chf
            cny = rates.cny
            czk = rates.czk
            dkk = rates.dkk
            gbp = rates.gbp
            hkd = rates.hkd
            hrk = rates.hrk
            huf = rates.huf
            idr = rates.idr
            ils = rates.ils
            inr = rates.inr
            isk = rates.isk
            jpy = rates.jpy
            krw = rates.krw
            mxn = rates.mxn
            myr = rates.myr
            nok = rates.nok
            nzd = rates.nzd
            php = rates.php
            pln = rates.pln
            ron = rates.ron
            rub = rates.rub
            sek = rates.sek
            sgd = rates.sgd
            thb = rates.thb
            tryy = rates.tryy
            usd = rates.usd
            zar = rates.zar
        }
    }

    private fun mapLocalRates(ratesLocal: RatesLocal): Rates {
        return Rates().apply {
            aud = ratesLocal.aud
            bgn = ratesLocal.bgn
            brl = ratesLocal.brl
            cad = ratesLocal.cad
            chf = ratesLocal.chf
            cny = ratesLocal.cny
            czk = ratesLocal.czk
            dkk = ratesLocal.dkk
            gbp = ratesLocal.gbp
            hkd = ratesLocal.hkd
            hrk = ratesLocal.hrk
            huf = ratesLocal.huf
            idr = ratesLocal.idr
            ils = ratesLocal.ils
            inr = ratesLocal.inr
            isk = ratesLocal.isk
            jpy = ratesLocal.jpy
            krw = ratesLocal.krw
            mxn = ratesLocal.mxn
            myr = ratesLocal.myr
            nok = ratesLocal.nok
            nzd = ratesLocal.nzd
            php = ratesLocal.php
            pln = ratesLocal.pln
            ron = ratesLocal.ron
            rub = ratesLocal.rub
            sek = ratesLocal.sek
            sgd = ratesLocal.sgd
            thb = ratesLocal.thb
            tryy = ratesLocal.tryy
            usd = ratesLocal.usd
            zar = ratesLocal.zar
        }
    }
}