package com.gresgo.aaa

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gresgo.feature.home.data.db.TestDao
import com.gresgo.feature.home.data.db.TestEntity

@Database(entities = [TestEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun testDao(): TestDao
}