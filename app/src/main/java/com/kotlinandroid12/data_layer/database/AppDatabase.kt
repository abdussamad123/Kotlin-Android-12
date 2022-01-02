package com.kotlinandroid12.data_layer.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kotlinandroid12.data_layer.database.daos.PostDao
import com.kotlinandroid12.data_layer.database.entities.PostEntity


@Database(entities =[PostEntity::class] ,version = 1,exportSchema = false)
abstract class AppDatabase:RoomDatabase() {

    abstract fun getPostDao():PostDao

    companion object{
        private  var dbInstance:AppDatabase? = null

        fun getDbInstance(context: Context):AppDatabase{

            if (dbInstance==null)
                dbInstance=Room.databaseBuilder(context.applicationContext,AppDatabase::class.java,"app_db")
                    .allowMainThreadQueries().build()

            return dbInstance as AppDatabase
        }
    }



}