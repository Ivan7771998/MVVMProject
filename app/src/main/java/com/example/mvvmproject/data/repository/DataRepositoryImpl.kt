package com.example.mvvmproject.data.repository

import com.example.mvvmproject.data.storage.DataStorage
import com.example.mvvmproject.domain.repository.DataRepository
import com.example.mvvmproject.domain.models.SampleData

class DataRepositoryImpl(private val dataStorage: DataStorage) : DataRepository {
    override fun saveData(sampleData: SampleData): Boolean {
        return dataStorage.save(sampleData = sampleData)
    }

    override fun getData(): SampleData {
        return dataStorage.get()
    }
}