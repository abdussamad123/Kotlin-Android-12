package com.kotlinandroid12.data_layer.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PostEntity(@PrimaryKey(autoGenerate = true) private var auto_id:Int,
                      @ColumnInfo(name = "post_id") private var post_id:String,
                      @ColumnInfo(name = "title") private var title:String,
                      @ColumnInfo(name = "body") private var body:String,
                      ) {
}