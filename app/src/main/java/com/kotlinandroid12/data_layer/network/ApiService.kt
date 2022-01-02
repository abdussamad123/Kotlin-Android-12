package com.kotlinandroid12.data_layer.network

import com.kotlinandroid12.data_layer.network.model.jsonholder.PostResponseData
import com.kotlinandroid12.data_layer.network.model.nrlm.OtpRequestBean
import com.kotlinandroid12.data_layer.network.model.nrlm.OtpResponseData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface NrlmApiServices{
    @POST("forgotPassword")
    fun otpApi(@Body otpRequestBean: OtpRequestBean): Call<OtpResponseData>
}


interface JsonHolderApiServices{

    @GET("posts")
    fun getPostApi():Call<List<PostResponseData>>

}