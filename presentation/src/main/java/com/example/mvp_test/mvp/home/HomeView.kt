package com.example.mvp_test.mvp.home

import android.os.Bundle
import android.os.Parcelable
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

    override fun init() {
        recycler = activity.findViewById(R.id.recycler)

        recycler.adapter = currencyAdapter
        recycler.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
    }

    override fun fillRecycler(baseRates: MutableMap<String, Double>) {
        currencyAdapter.addItems(baseRates)
        recycler.layoutManager?.onRestoreInstanceState(recyclerState)
    }

    override fun setOnTapCurrencyListener(listener: (baseRate: String) -> Unit) {
        currencyAdapter.setOnTapCurrencyListener(listener)
    }

    override fun scrollRecyclerToTop() {
        recycler.smoothScrollToPosition(0)
        recyclerState = null
    }

    override fun saveInstanceState() {
        if (::recycler.isInitialized) {
            recyclerState = recycler.layoutManager?.onSaveInstanceState()
        }
    }

    override fun clearInstanceState() {
        recycler.layoutManager?.onRestoreInstanceState(null)
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

    companion object {
        private const val RECYCLER_STATE = "BUNDLE_RECYCLER_STATE"
    }
}