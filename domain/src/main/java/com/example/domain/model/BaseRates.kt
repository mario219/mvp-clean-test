package com.example.domain.model

import com.example.domain.constants.EMPTY_STRING

data class BaseRates(var base: String = EMPTY_STRING, var date: String = EMPTY_STRING, var rates: Rates = Rates())