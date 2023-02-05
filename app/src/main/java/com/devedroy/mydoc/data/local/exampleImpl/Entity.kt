package com.devedroy.mydoc.data.local.exampleImpl

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table1")
data class Table1(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val value: Int
)

@Entity(tableName = "table2")
data class Table2(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val description: String
)

