package com.example.data.model.remote

import com.google.gson.annotations.SerializedName

data class BaseRatesRemote(
    @SerializedName("base") val base: String,
    @SerializedName("date") val date: String,
    @SerializedName("rates") val rates: RatesRemote
)