package com.kotlinandroid12.data_layer.repositories

import com.kotlinandroid12.data_layer.network.JsonHolderApiServices
import com.kotlinandroid12.data_layer.network.NrlmApiServices
import com.kotlinandroid12.data_layer.network.model.jsonholder.PostResponseData
import com.kotlinandroid12.data_layer.network.model.nrlm.OtpRequestBean
import com.kotlinandroid12.data_layer.network.model.nrlm.OtpResponseData
import com.kotlinandroid12.util.AppUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class MainActivityRepo @Inject constructor(private var nrlmApiServices: NrlmApiServices, private var jsonHolderApiServices: JsonHolderApiServices) {


    fun callOtpApi(otpRequestBean: OtpRequestBean){

        var call: Call<OtpResponseData> = nrlmApiServices.otpApi(otpRequestBean)
        call.enqueue(object :Callback<OtpResponseData> {
            override fun onResponse(call: Call<OtpResponseData>, response: Response<OtpResponseData>){
                AppUtil.showLog(response.body().toString(),MainActivityRepo::class.java)
            }
            override fun onFailure(call: Call<OtpResponseData>, t: Throwable) {
                AppUtil.showLog(t.message.toString(),MainActivityRepo::class.java)
            }
        })
    }

    fun callPostApi(){
        var call:Call<List<PostResponseData>> = jsonHolderApiServices.getPostApi()
        call.enqueue(object : Callback<List<PostResponseData>>{
            override fun onResponse(call: Call<List<PostResponseData>>,response: Response<List<PostResponseData>>) {
                AppUtil.showLog(response.body().toString(),MainActivityRepo::class.java)
            }
            override fun onFailure(call: Call<List<PostResponseData>>, t: Throwable) {
                AppUtil.showLog(t.message.toString(),MainActivityRepo::class.java)
            }
        })
    }

}
