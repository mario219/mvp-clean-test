package com.example.mvp_test.mvp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvp_test.R
import com.example.mvp_test.mvp.home.HomeContract
import dagger.android.AndroidInjection
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject lateinit var presenter: HomeContract.HomePresenter

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
        presenter.initCurrencyObserver()
    }
}
