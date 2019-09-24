package com.example.mvp_test.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.domain.constants.BASE_RATE
import com.example.mvp_test.R
import com.example.mvp_test.mvp.home.HomeContract
import dagger.android.AndroidInjection
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject lateinit var presenter: HomeContract.HomePresenter
    private var baseRate = BASE_RATE

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun onResume() {
        super.onResume()
        presenter.initCurrencyObserver(baseRate)
        presenter.setOnTapCurrencyListener()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        presenter.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        presenter.onRestoreInstanceState(savedInstanceState)
    }
}
