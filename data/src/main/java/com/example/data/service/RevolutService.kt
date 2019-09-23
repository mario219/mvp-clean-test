package com.example.data.service

import com.example.data.model.remote.BaseRatesRemote
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RevolutService {

    @GET("latest")
    fun getLatests(@Query("base") base: String): Single<BaseRatesRemote>
}