package com.kotlinandroid12.di

import android.content.Context
import com.kotlinandroid12.data_layer.database.AppDatabase
import com.kotlinandroid12.data_layer.database.daos.PostDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Singleton
    @Provides
    fun getDbInstance(context: Context):AppDatabase{
     return AppDatabase.getDbInstance(context)
    }

    @Singleton
    @Provides
    fun getPostDao(appDatabase: AppDatabase):PostDao{
        return appDatabase.getPostDao()
    }
}