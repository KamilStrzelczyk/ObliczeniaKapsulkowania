package com.example.kaspukowaniev3.infostructure.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "series_table")
data class SeriesEntity(

    @PrimaryKey val id: Int,

    @ColumnInfo(name = "numberOfSeries")
    var numberOfSeries: String,
)

