package com.example.notepad.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note (

    @ColumnInfo(name = "Title")
    val title: String,
    @ColumnInfo(name = "note")
    val note: String,
    @ColumnInfo(name = "date_time")
    val date: String

    ){
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0
}