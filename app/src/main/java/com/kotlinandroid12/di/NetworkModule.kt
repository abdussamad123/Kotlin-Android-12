package com.kotlinandroid12.di

import com.kotlinandroid12.data_layer.network.JsonHolderApiServices
import com.kotlinandroid12.data_layer.network.NrlmApiServices
import com.kotlinandroid12.util.AppConstant
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class JsonHolderOkHttpClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NrlmOkHttpClient

@Module
@InstallIn(
    SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun getJsonHolderApiService(@JsonHolderOkHttpClient okHttpClient: OkHttpClient): JsonHolderApiServices {
        val moshi = Moshi.Builder().add(
            KotlinJsonAdapterFactory()
        ).build()
        return Retrofit.Builder().addConverterFactory(
            MoshiConverterFactory.create(moshi)).baseUrl(AppConstant.jsonHolderBaseUrl)
            .client(okHttpClient).build().create(JsonHolderApiServices::class.java)
    }

    @Singleton
    @JsonHolderOkHttpClient
    @Provides
    fun provideJsonHolderOkHttpClient():OkHttpClient{
        return OkHttpClient().newBuilder().addInterceptor(
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(
                AppConstant.retrofitConnectionTimeOut,
                TimeUnit.MILLISECONDS)
            .readTimeout(AppConstant.retrofitReadTimeOut,TimeUnit.MILLISECONDS)
            .retryOnConnectionFailure(false).build()
    }

    @Singleton
    @Provides
    fun getNrlmApiService(@NrlmOkHttpClient okHttpClient: OkHttpClient): NrlmApiServices {
        val moshi:Moshi=Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        return Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(AppConstant.nrlmBaseUrl)
            .client(okHttpClient).build().create(NrlmApiServices::class.java)
    }

    @Singleton
    @NrlmOkHttpClient
    @Provides
    fun provideNrlmOkHttpClient():OkHttpClient{
        return OkHttpClient().newBuilder().addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(AppConstant.retrofitConnectionTimeOut,TimeUnit.MILLISECONDS)
            .readTimeout(AppConstant.retrofitReadTimeOut,TimeUnit.MILLISECONDS)
            .retryOnConnectionFailure(false).build()
    }

}