package com.example.mvvmproject.data.storage.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    suspend fun getAll(): List<User>

    @Insert
    suspend fun insert(user: User)

    // @Query("SELECT * FROM user Where  name = $name ")
    // fun getName(name: String): List<User>
}