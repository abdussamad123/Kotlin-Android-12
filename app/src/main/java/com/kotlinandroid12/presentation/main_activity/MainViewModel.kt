package com.kotlinandroid12.presentation.main_activity

import androidx.lifecycle.ViewModel
import com.kotlinandroid12.data_layer.network.model.nrlm.OtpRequestBean
import com.kotlinandroid12.data_layer.repositories.MainActivityRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private var mainActivityRepo: MainActivityRepo) : ViewModel(){


    fun callOptApi(otpRequestBean: OtpRequestBean) {
    mainActivityRepo.callOtpApi(otpRequestBean)
    }

    fun callPostApi() {
        mainActivityRepo.callPostApi()
    }




}