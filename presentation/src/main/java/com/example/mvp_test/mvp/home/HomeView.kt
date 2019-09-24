package com.example.mvp_test.mvp.home

import android.os.Bundle
import android.os.Parcelable
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.BaseRates
import com.example.domain.model.Rates
import com.example.mvp_test.R
import com.example.mvp_test.activities.HomeActivity
import com.example.mvp_test.adapters.CurrencyAdapter
import javax.inject.Inject

class HomeView @Inject constructor(
    private val activity: HomeActivity
) : HomeContract.HomeView {

    private lateinit var recycler: RecyclerView
    private var recyclerState: Parcelable? = null
    private var currencyAdapter: CurrencyAdapter = CurrencyAdapter()

    override fun fillRecycler(baseRates: BaseRates) {
        recycler = activity.findViewById(R.id.recycler)
        recycler.adapter = currencyAdapter
        recycler.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        // currencyAdapter.addItems(createListOfRates(baseRates.rates))
        recycler.layoutManager?.onRestoreInstanceState(recyclerState)
    }

    override fun setOnTapCurrencyListener(listener: (baseRate: String) -> Unit) {
        currencyAdapter.setOnTapCurrencyListener(listener)
    }

    override fun saveInstanceState() {
        if (::recycler.isInitialized) {
            recyclerState = recycler.layoutManager?.onSaveInstanceState()
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.run {
            putParcelable(RECYCLER_STATE, recycler.layoutManager?.onSaveInstanceState())
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        savedInstanceState?.run {
            recycler.layoutManager?.onRestoreInstanceState(getParcelable(RECYCLER_STATE))
        }
    }

    private fun createListOfRates(rates: Rates) =
        listOf(
            rates.aud,
            rates.bgn,
            rates.brl,
            rates.cad,
            rates.chf,
            rates.cny,
            rates.czk,
            rates.dkk,
            rates.gbp,
            rates.hkd,
            rates.hrk,
            rates.huf,
            rates.idr,
            rates.ils,
            rates.inr,
            rates.isk,
            rates.jpy,
            rates.krw,
            rates.mxn,
            rates.myr,
            rates.nok,
            rates.nzd,
            rates.php,
            rates.pln,
            rates.ron,
            rates.rub,
            rates.sek,
            rates.sgd,
            rates.thb,
            rates.tryy,
            rates.usd,
            rates.zar
        )

    companion object {
        private const val RECYCLER_STATE = "BUNDLE_RECYCLER_STATE"
    }
}