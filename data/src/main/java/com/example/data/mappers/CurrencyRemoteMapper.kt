package com.example.data.mappers

import com.example.data.model.remote.BaseRatesRemote
import com.example.data.model.remote.RatesRemote
import com.example.domain.model.BaseRates
import com.example.domain.model.Rates
import javax.inject.Inject

internal class CurrencyRemoteMapper @Inject constructor() : BaseRemoteMapper<BaseRatesRemote, BaseRates> {

    override fun transform(input: BaseRatesRemote) =
        BaseRates().apply {
            base = input.base
            date = input.date
            rates = mapRemoteRates(input.rates)
        }

    private fun mapRemoteRates(rates: RatesRemote) =
        Rates().apply {
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