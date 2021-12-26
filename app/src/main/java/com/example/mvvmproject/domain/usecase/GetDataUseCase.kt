package com.example.mvvmproject.domain.usecase

import com.example.mvvmproject.domain.models.SampleData
import com.example.mvvmproject.domain.repository.DataRepository

class GetDataUseCase(private val dataRepository: DataRepository) {

    fun run(): SampleData {
        return dataRepository.getData()
    }
}