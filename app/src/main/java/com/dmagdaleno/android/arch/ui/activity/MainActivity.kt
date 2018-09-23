package com.dmagdaleno.android.arch.ui.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import com.dmagdaleno.android.arch.R
import com.dmagdaleno.android.arch.ui.model.DataViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(DataViewModel::class.java)
        viewModel.getDataList().observe(this, Observer {
            dataList ->
                dataList?.let {
                    val listItems = arrayOf(
                        dataList[0].toString(),
                        dataList[1].toString(),
                        dataList[2].toString()
                    )

                    val listAdapter = ArrayAdapter(this,
                                    android.R.layout.simple_list_item_1, listItems)

                    list.adapter = listAdapter
                }

        })

    }
}
