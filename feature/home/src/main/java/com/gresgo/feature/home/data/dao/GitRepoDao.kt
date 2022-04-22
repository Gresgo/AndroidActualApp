package com.gresgo.feature.home.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gresgo.feature.home.data.model.GitRepoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GitRepoDao {

    @Query("""SELECT * FROM GitRepoEntity""")
    fun observe(): Flow<List<GitRepoEntity>>

    @Query("""SELECT * FROM GitRepoEntity""")
    suspend fun queryAll(): List<GitRepoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: GitRepoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<GitRepoEntity>)

}