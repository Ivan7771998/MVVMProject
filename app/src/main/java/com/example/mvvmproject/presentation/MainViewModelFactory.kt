package com.example.mvvmproject.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmproject.data.repository.DataRepositoryImpl
import com.example.mvvmproject.data.storage.RoomStorage
import com.example.mvvmproject.domain.usecase.GetDataUseCase
import com.example.mvvmproject.domain.usecase.SaveDataUseCase

class MainViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    private val dataRepository by lazy(LazyThreadSafetyMode.NONE) {
        DataRepositoryImpl(dataStorage = RoomStorage(context = context))
    }

    private val getDataUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetDataUseCase(dataRepository = dataRepository)
    }

    private val saveDataUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveDataUseCase(dataRepository = dataRepository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getDataUseCase = getDataUseCase, saveDataUseCase = saveDataUseCase) as T
    }
}