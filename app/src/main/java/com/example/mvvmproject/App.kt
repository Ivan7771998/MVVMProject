package com.example.mvvmproject

import android.app.Application
import com.example.mvvmproject.data.storage.room.AppDatabase

class App : Application() {


    override fun onCreate() {
        super.onCreate()
        //AppDatabase.invoke(applicationContext)
    }
}