package com.dmagdaleno.android.arch.ui.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.dmagdaleno.android.arch.model.Data

class DataViewModel: ViewModel() {

    private val dataList: LiveData<List<Data>>

    init {
        Log.d("ViewModel", "building model")

        val data1 = Data("val1", "val2", "val3")
        val data2 = Data("val1", "val2", "val3")
        val data3 = Data("val1", "val2", "val3")

        dataList = MutableLiveData<List<Data>>()
        dataList.value = listOf(data1, data2, data3)
    }

    fun getDataList() = dataList
}