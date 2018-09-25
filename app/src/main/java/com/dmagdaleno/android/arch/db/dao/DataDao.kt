package com.dmagdaleno.android.arch.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.dmagdaleno.android.arch.model.Data

@Dao
interface DataDao {

    @Insert
    fun insert(data: Data)

    @Query("SELECT * FROM data")
    fun getAll(): LiveData<List<Data>>

    @Query("SELECT * FROM data WHERE id = :id")
    fun findBy(id: Int): LiveData<Data>
}