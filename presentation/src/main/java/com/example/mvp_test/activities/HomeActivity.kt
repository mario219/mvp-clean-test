package com.example.mvp_test.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.domain.constants.ZERO_DOUBLE
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
        addWatcher()
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

    private fun addWatcher() {
        activityHomeBinding.layoutRow.inputCurrency.addTextChangedListener(object: TextWatcher {

            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                p0?.let { input ->
                    if (input.toString().isNotEmpty()) {
                        presenter.setMultiplier(input.toString().toDouble())
                    } else {
                        presenter.setMultiplier(ZERO_DOUBLE)
                    }
                }
            }
        })
    }
}
