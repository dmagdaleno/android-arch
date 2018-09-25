package com.dmagdaleno.android.arch.ui.model

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Room
import android.util.Log
import com.dmagdaleno.android.arch.db.AppDatabase
import com.dmagdaleno.android.arch.model.Data

class DataViewModel(application: Application) : AndroidViewModel(application) {

    private val dataList: LiveData<List<Data>>

    init {
        Log.d("ViewModel", "building model")
        val database = Room
                .databaseBuilder(application, AppDatabase::class.java, "app.db")
                .build()

        dataList = database.getDataDao().getAll()
    }

    fun getDataList() = dataList
}