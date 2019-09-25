package com.example.mvp_test.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.constants.ONE_DOUBLE
import com.example.mvp_test.databinding.ItemCurrencyBinding
import com.example.mvp_test.model.CurrencyDataModel

class CurrencyAdapter : RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder>() {

    private var ratesKeys = listOf<String>()
    private var ratesValues = listOf<Double>()
    private lateinit var listener: (baseRate: String) -> Unit
    private var multiplier = ONE_DOUBLE

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder =
        CurrencyViewHolder(ItemCurrencyBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount() = ratesKeys.size

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        holder.bind(ratesKeys[position], ratesValues[position].times(multiplier))
    }

    fun addItems(rates: MutableMap<String, Double>) {
        ratesKeys = rates.keys.toList()
        ratesValues = rates.values.toList()
        notifyDataSetChanged()
    }

    fun setOnTapCurrencyListener(listener: (baseRate: String) -> Unit) {
        this.listener = listener
    }

    fun setMultiplier(number: Double) {
        multiplier = number
    }

    inner class CurrencyViewHolder(private val itemBinded: ItemCurrencyBinding) : RecyclerView.ViewHolder(itemBinded.root) {

        @SuppressLint("ClickableViewAccessibility")
        fun bind(cCode: String, rate: Double) {
            itemBinded.currencyDataModel = CurrencyDataModel(cCode, rate)
            itemBinded.executePendingBindings()
            itemBinded.inputCurrency.isFocusable = false
            itemBinded.inputCurrency.setOnTouchListener { p0, p1 ->
                listener(cCode)
                false
            }
        }
    }
}