package com.kotlinandroid12.util

import android.util.Log

object AppUtil {

    fun <T>showLog( msg:String, classType:Class<T>){
        if (AppConstant.wantToShow){
            Log.e(classType.canonicalName, msg )
        }
    }
}