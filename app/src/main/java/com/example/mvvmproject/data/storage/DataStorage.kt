package com.example.mvvmproject.data.storage

import com.example.mvvmproject.domain.models.SampleData

interface DataStorage {

    fun save(sampleData: SampleData): Boolean

    fun get(): SampleData
}