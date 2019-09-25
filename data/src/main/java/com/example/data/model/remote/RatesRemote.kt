package com.example.data.model.remote

import com.example.domain.constants.ONE_DOUBLE
import com.google.gson.annotations.SerializedName

data class RatesRemote (
    @SerializedName("EUR") var eur: Double = ONE_DOUBLE,
    @SerializedName("AUD") var aud: Double = ONE_DOUBLE,
    @SerializedName("BGN") var bgn: Double = ONE_DOUBLE,
    @SerializedName("BRL") var brl: Double = ONE_DOUBLE,
    @SerializedName("CAD") var cad: Double = ONE_DOUBLE,
    @SerializedName("CHF") var chf: Double = ONE_DOUBLE,
    @SerializedName("CNY") var cny: Double = ONE_DOUBLE,
    @SerializedName("CZK") var czk: Double = ONE_DOUBLE,
    @SerializedName("DKK") var dkk: Double = ONE_DOUBLE,
    @SerializedName("GBP") var gbp: Double = ONE_DOUBLE,
    @SerializedName("HKD") var hkd: Double = ONE_DOUBLE,
    @SerializedName("HRK") var hrk: Double = ONE_DOUBLE,
    @SerializedName("HUF") var huf: Double = ONE_DOUBLE,
    @SerializedName("IDR") var idr: Double = ONE_DOUBLE,
    @SerializedName("ILS") var ils: Double = ONE_DOUBLE,
    @SerializedName("INR") var inr: Double = ONE_DOUBLE,
    @SerializedName("ISK") var isk: Double = ONE_DOUBLE,
    @SerializedName("JPY") var jpy: Double = ONE_DOUBLE,
    @SerializedName("KRW") var krw: Double = ONE_DOUBLE,
    @SerializedName("MXN") var mxn: Double = ONE_DOUBLE,
    @SerializedName("MYR") var myr: Double = ONE_DOUBLE,
    @SerializedName("NOK") var nok: Double = ONE_DOUBLE,
    @SerializedName("NZD") var nzd: Double = ONE_DOUBLE,
    @SerializedName("PHP") var php: Double = ONE_DOUBLE,
    @SerializedName("PLN") var pln: Double = ONE_DOUBLE,
    @SerializedName("RON") var ron: Double = ONE_DOUBLE,
    @SerializedName("RUB") var rub: Double = ONE_DOUBLE,
    @SerializedName("SEK") var sek: Double = ONE_DOUBLE,
    @SerializedName("SGD") var sgd: Double = ONE_DOUBLE,
    @SerializedName("THB") var thb: Double = ONE_DOUBLE,
    @SerializedName("TRY") var tryy: Double = ONE_DOUBLE,
    @SerializedName("USD") var usd: Double = ONE_DOUBLE,
    @SerializedName("ZAR") var zar: Double = ONE_DOUBLE
)