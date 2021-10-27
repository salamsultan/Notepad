package com.example.notepad.repository

import com.example.notepad.database.Note
import com.example.notepad.database.NoteDatabase

class NoteRepository(private val db: NoteDatabase) {


    suspend fun addNote(note: Note) = db.noteDao().insertNote(note)
    suspend fun updateNote(note: Note) = db.noteDao().updateNote(note)
    suspend fun deleteNote(note: Note) = db.noteDao().deleteNote(note)
    fun getAllNote() = db.noteDao().getAllNote()


}