package com.dmagdaleno.android.arch.ui.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.arch.persistence.room.Room
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import com.dmagdaleno.android.arch.R
import com.dmagdaleno.android.arch.db.AppDatabase
import com.dmagdaleno.android.arch.model.Data
import com.dmagdaleno.android.arch.ui.model.DataViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(DataViewModel::class.java)
        viewModel.getDataList().observe(this, Observer {
            dataList ->
                dataList?.let {
                    val listItems = it.map { data -> data.toString() }.toTypedArray()

                    val listAdapter = ArrayAdapter(this,
                                    android.R.layout.simple_list_item_1, listItems)

                    list.adapter = listAdapter
                }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_load_data -> loadData()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun loadData() {
        val data = Data(attr1 = "val1", attr2 = "val2", attr3 = "val3")

        doAsync {
            val database = Room
                    .databaseBuilder(application, AppDatabase::class.java, "app.db")
                    .build()

            val dao = database.getDataDao()

            dao.insert(data)
            dao.insert(data)
            dao.insert(data)
        }

    }
}
