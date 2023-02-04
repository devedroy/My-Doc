package com.devedroy.mydoc.data.local.exampleImpl

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Table1::class, Table2::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun table1Dao(): Table1Dao
    abstract fun table2Dao(): Table2Dao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext, AppDatabase::class.java, "app_database"
        ).build()
    }
}
