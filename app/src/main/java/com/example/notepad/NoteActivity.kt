package com.example.notepad

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.notepad.database.Note
import com.example.notepad.database.NoteDatabase
import com.example.notepad.databinding.ActivityNoteBinding

private lateinit var binding: ActivityNoteBinding

class NoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        noteViewModel


        binding.imgBack.setOnClickListener {
            startActivity(Intent(this@NoteActivity, MainActivity::class.java))
            finish()
        }

        binding.imageDone.setOnClickListener {

            val noteTitle = binding.etTitle.text.toString().trim()
            val noteBody = binding.etNote.text.toString().trim()
            val dateTime = binding.dateTime.text.toString().trim()

            if (noteBody.isEmpty()) {

                binding.etNote.error = ""
                binding.etNote.requestFocus()
                return@setOnClickListener
            }

            val note = Note(noteTitle, noteBody, dateTime)
            saveNote(note)

        }


    }

    private fun saveNote(note: Note) {

        noteViewModel.addNote(note)
        Toast.makeText(applicationContext, "Note Saved Successfully", Toast.LENGTH_LONG).show()
    }
    
    /*private fun saveNote(note: Note) {
        class SaveNote : AsyncTask<Void, Void, Void>(){

            override fun doInBackground(vararg p0: Void?): Void?  {
                NoteDatabase(applicationContext).noteDao().getAllNote()
                return null
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)

                Toast.makeText(applicationContext, "Note Saved", Toast.LENGTH_SHORT).show()
            }

        }
            SaveNote().execute()
    }*/
    
}