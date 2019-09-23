package com.example.data.model.cache

import com.example.domain.constants.EMPTY_STRING
import io.realm.RealmObject

open class BaseRatesLocal (
    var id: Int = 1, var base: String = EMPTY_STRING, var date: String = EMPTY_STRING, var rates: RatesLocal? = RatesLocal()
) : RealmObject()