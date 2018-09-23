package com.dmagdaleno.android.arch.ui.model

import android.arch.lifecycle.ViewModel
import android.util.Log
import com.dmagdaleno.android.arch.model.Data

class DataViewModel(): ViewModel() {

    private val datas: List<Data>

    init {
        Log.i("ViewModel", "building model")

        val data1 = Data("val1", "val2", "val3")
        val data2 = Data("val1", "val2", "val3")
        val data3 = Data("val1", "val2", "val3")
        datas = listOf(data1, data2, data3)
    }

    fun getDataList() = datas
}