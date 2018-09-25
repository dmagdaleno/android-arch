package com.dmagdaleno.android.arch.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.dmagdaleno.android.arch.db.dao.DataDao
import com.dmagdaleno.android.arch.model.Data

@Database(entities = [(Data::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDataDao(): DataDao
}