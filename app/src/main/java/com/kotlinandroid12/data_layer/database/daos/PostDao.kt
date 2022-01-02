package com.kotlinandroid12.data_layer.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.kotlinandroid12.data_layer.database.entities.PostEntity

@Dao
interface PostDao {

    @Insert(
        onConflict = OnConflictStrategy.IGNORE
    )
    fun insertAll(
        postEntityList: List<PostEntity>
    )

}