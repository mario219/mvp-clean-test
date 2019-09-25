package com.example.mvp_test.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.domain.constants.ZERO_DOUBLE

fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}

fun <T> fillWithZeroValues(list: List<T>): List<Double> {
    val listOf = mutableListOf<Double>()
    for (element in list) {
        listOf.add(ZERO_DOUBLE)
    }
    return listOf.toList()
}