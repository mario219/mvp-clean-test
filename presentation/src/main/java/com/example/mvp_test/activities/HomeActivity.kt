package com.example.mvp_test.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.domain.constants.BASE_RATE
import com.example.mvp_test.R
import com.example.mvp_test.databinding.ActivityHomeBinding
import com.example.mvp_test.mvp.home.HomeContract
import com.example.mvp_test.mvp.home.HomePresenter
import dagger.android.AndroidInjection
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject lateinit var presenter: HomeContract.HomePresenter
    private lateinit var activityHomeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        activityHomeBinding.lifecycleOwner = this
        activityHomeBinding.presenter = presenter as HomePresenter
        setContentView(activityHomeBinding.root)
        presenter.initView()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun onResume() {
        super.onResume()
        presenter.initCurrencyObserver()
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
