package com.example.data.model.remote

import com.example.domain.constants.ZERO_DOUBLE
import com.google.gson.annotations.SerializedName

data class RatesRemote (
    @SerializedName("AUD") var aud: Double = ZERO_DOUBLE,
    @SerializedName("BGN") var bgn: Double = ZERO_DOUBLE,
    @SerializedName("BRL") var brl: Double = ZERO_DOUBLE,
    @SerializedName("CAD") var cad: Double = ZERO_DOUBLE,
    @SerializedName("CHF") var chf: Double = ZERO_DOUBLE,
    @SerializedName("CNY") var cny: Double = ZERO_DOUBLE,
    @SerializedName("CZK") var czk: Double = ZERO_DOUBLE,
    @SerializedName("DKK") var dkk: Double = ZERO_DOUBLE,
    @SerializedName("GBP") var gbp: Double = ZERO_DOUBLE,
    @SerializedName("HKD") var hkd: Double = ZERO_DOUBLE,
    @SerializedName("HRK") var hrk: Double = ZERO_DOUBLE,
    @SerializedName("HUF") var huf: Double = ZERO_DOUBLE,
    @SerializedName("IDR") var idr: Double = ZERO_DOUBLE,
    @SerializedName("ILS") var ils: Double = ZERO_DOUBLE,
    @SerializedName("INR") var inr: Double = ZERO_DOUBLE,
    @SerializedName("ISK") var isk: Double = ZERO_DOUBLE,
    @SerializedName("JPY") var jpy: Double = ZERO_DOUBLE,
    @SerializedName("KRW") var krw: Double = ZERO_DOUBLE,
    @SerializedName("MXN") var mxn: Double = ZERO_DOUBLE,
    @SerializedName("MYR") var myr: Double = ZERO_DOUBLE,
    @SerializedName("NOK") var nok: Double = ZERO_DOUBLE,
    @SerializedName("NZD") var nzd: Double = ZERO_DOUBLE,
    @SerializedName("PHP") var php: Double = ZERO_DOUBLE,
    @SerializedName("PLN") var pln: Double = ZERO_DOUBLE,
    @SerializedName("RON") var ron: Double = ZERO_DOUBLE,
    @SerializedName("RUB") var rub: Double = ZERO_DOUBLE,
    @SerializedName("SEK") var sek: Double = ZERO_DOUBLE,
    @SerializedName("SGD") var sgd: Double = ZERO_DOUBLE,
    @SerializedName("THB") var thb: Double = ZERO_DOUBLE,
    @SerializedName("TRY") var tryy: Double = ZERO_DOUBLE,
    @SerializedName("USD") var usd: Double = ZERO_DOUBLE,
    @SerializedName("ZAR") var zar: Double = ZERO_DOUBLE
)