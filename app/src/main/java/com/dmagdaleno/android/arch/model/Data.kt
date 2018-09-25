package com.dmagdaleno.android.arch.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Data(
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0,
        var attr1: String = "undefined",
        var attr2: String = "undefined",
        var attr3: String = "undefined"
)