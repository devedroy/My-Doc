package com.devedroy.mydoc.data.local.exampleImpl

import androidx.room.*

@Dao
interface Table1Dao {
    @Insert
    fun insert(table1: Table1)

    @Update
    fun update(table1: Table1)

    @Delete
    fun delete(table1: Table1)

    @Query("SELECT * FROM table1")
    fun getAll(): List<Table1>
}

@Dao
interface Table2Dao {
    @Insert
    fun insert(table2: Table2)

    @Update
    fun update(table2: Table2)

    @Delete
    fun delete(table2: Table2)

    @Query("SELECT * FROM table2")
    fun getAll(): List<Table2>
}
