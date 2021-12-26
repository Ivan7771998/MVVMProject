package com.example.mvvmproject.domain.repository

import com.example.mvvmproject.domain.models.SampleData

interface DataRepository {

    fun saveData(sampleData: SampleData): Boolean

    fun getData(): SampleData
}