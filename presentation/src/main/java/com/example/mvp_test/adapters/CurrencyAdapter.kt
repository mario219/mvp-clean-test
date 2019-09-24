package com.example.mvp_test.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.constants.listOfCurrencyCodes
import com.example.mvp_test.R
import com.example.mvp_test.utils.inflate

class CurrencyAdapter : RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder>() {

    private var ratesInfo = listOf<Double>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder =
        CurrencyViewHolder(parent.inflate(R.layout.item_currency))

    override fun getItemCount() = ratesInfo.size

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        holder.bind(listOfCurrencyCodes[position].toUpperCase(), ratesInfo[position])
    }

    fun addItems(rates: List<Double>) {
        ratesInfo = rates
        notifyDataSetChanged()
    }

    inner class CurrencyViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        fun bind(ccode: String, rate: Double) {
            if (!firstLoadDone) {
                currencyCode.text = ccode
                firstLoadDone = true
            }
            inputCurrency.setText(rate.toString())
        }

        private val countryFlag: ImageView = item.findViewById(R.id.img_country_currency)
        private val currencyCode: TextView = item.findViewById(R.id.text_currency_code)
        private val currencyCountry: TextView = item.findViewById(R.id.text_country_currency)
        private val inputCurrency: EditText = item.findViewById(R.id.input_currency)

        private var firstLoadDone = false
    }
}