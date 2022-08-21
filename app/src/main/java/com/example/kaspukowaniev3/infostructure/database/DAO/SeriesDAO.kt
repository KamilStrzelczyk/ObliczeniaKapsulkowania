package com.example.kaspukowaniev3.infostructure.database.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.kaspukowaniev3.infostructure.database.entities.SeriesEntity

@Dao
interface SeriesDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: SeriesEntity)
}