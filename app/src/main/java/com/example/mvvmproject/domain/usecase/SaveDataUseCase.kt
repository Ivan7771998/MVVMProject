package com.example.mvvmproject.domain.usecase

import com.example.mvvmproject.domain.models.SampleData
import com.example.mvvmproject.domain.repository.DataRepository

class SaveDataUseCase(private val dataRepository: DataRepository) {

    fun run(data: SampleData): Boolean {
        return dataRepository.saveData(data)
    }
}