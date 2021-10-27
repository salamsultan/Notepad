package com.example.notepad.database

import androidx.room.*

interface NoteDao {

    @Query("SELECT * FROM notes ORDER BY id DESC")
    fun getAllNote(): List<Note>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(vararg note: Note)

    @Update
    fun updateNote(vararg note: Note)

    @Delete
    fun deleteNote(vararg note: Note)
}