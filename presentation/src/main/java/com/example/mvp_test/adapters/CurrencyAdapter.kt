package com.example.mvp_test.adapters

import android.annotation.SuppressLint
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.constants.ZERO_DOUBLE
import com.example.mvp_test.databinding.ItemCurrencyBinding
import com.example.mvp_test.model.CurrencyDataModel

class CurrencyAdapter : RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder>() {

    private var ratesKeys = listOf<String>()
    private var ratesValues = listOf<Double>()
    private lateinit var listener: (baseRate: String) -> Unit
    private var factor = 1.0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder =
        CurrencyViewHolder(ItemCurrencyBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount() = ratesKeys.size

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        holder.bind(ratesKeys[position], ratesValues[position])
    }

    fun addItems(rates: MutableMap<String, Double>) {
        ratesKeys = rates.keys.toList()
        ratesValues = rates.values.toList()
        notifyDataSetChanged()
    }

    fun setOnTapCurrencyListener(listener: (baseRate: String) -> Unit) {
        this.listener = listener
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

    inner class CurrencyInputWatcher : TextWatcher {

        override fun afterTextChanged(p0: Editable?) {

        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            p0?.let { input ->
                factor = if (input.toString().isNotEmpty()) {
                     input.toString().toDouble()
                } else {
                    ZERO_DOUBLE
                }
            }
        }
    }
}