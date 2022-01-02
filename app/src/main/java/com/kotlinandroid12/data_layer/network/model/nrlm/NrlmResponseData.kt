package com.kotlinandroid12.data_layer.network.model.nrlm

data class OtpResponseData(private var status:Int,private var error:Error)

data class Error(private var code:String, private var message:String)