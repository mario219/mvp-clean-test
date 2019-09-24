package com.example.data.mappers

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.realm.RealmObject

interface BaseMapper<T: RealmObject, F> {
    fun transform(input: T): F
    fun transform(input: F): T
}

interface BaseRemoteMapper<T, F> {
    fun transform(input: T): F
}

abstract class MapperUtils {

    val gson = Gson()

    fun <T> T.serializeToMap(): Map<String, Double> {
        return convert()
    }

    inline fun <I, reified O> I.convert(): O {
        val json = gson.toJson(this)
        return gson.fromJson(json, object : TypeToken<O>() {}.type)
    }
}