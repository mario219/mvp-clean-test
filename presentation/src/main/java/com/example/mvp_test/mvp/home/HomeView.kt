package com.example.mvp_test.mvp.home

import com.example.mvp_test.mvp.activity.HomeActivity
import javax.inject.Inject

class HomeView @Inject constructor(
    private val activity: HomeActivity
) : HomeContract.HomeView