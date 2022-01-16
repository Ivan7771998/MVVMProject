package com.example.mvvmproject.data.storage

import android.content.Context
import com.example.mvvmproject.data.storage.room.AppDatabase
import com.example.mvvmproject.data.storage.room.User
import com.example.mvvmproject.domain.models.SampleData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class RoomStorage(context: Context) : DataStorage {

    private val userDao = AppDatabase.getDatabase(context).userDao()
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    override fun save(sampleData: SampleData): Boolean {
        coroutineScope.launch {
            userDao.insert(User(name = sampleData.text))
        }
        return true
    }

    override fun get(): SampleData {
        val users = runBlocking {
            withContext(Dispatchers.Default) { userDao.getAll() }
        }
        return SampleData(text = users.first().name.toString())
    }
}