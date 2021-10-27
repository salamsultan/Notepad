package com.example.notepad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notepad.database.NoteDatabase
import com.example.notepad.databinding.ActivityMainBinding
import com.example.notepad.repository.NoteRepository
import com.example.notepad.viewmodel.NoteViewModel
import com.example.notepad.viewmodel.NoteViewModelFactoryProvider

private lateinit var  binding: ActivityMainBinding
lateinit var noteViewModel: NoteViewModel
lateinit var noteAdapter: NoteAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.setOnClickListener {

            startActivity(Intent(this@MainActivity, NoteActivity::class.java))
            finish()
        
        }

        setUpViewModel()
        setupRecyclerview()
    }


    private fun setupRecyclerview() {

        noteAdapter = NoteAdapter()

        binding.recyclerView.apply {

            val layoutManager = LinearLayoutManager(this@MainActivity)
            layoutManager.orientation = LinearLayoutManager.HORIZONTAL

            setHasFixedSize(true)
            adapter = noteAdapter

        }

        noteViewModel.getAllNote()

    }



    private fun setUpViewModel(){

        val noteRepository = NoteRepository(
            NoteDatabase(this)
        )

        val viewModelFactoryProvider = NoteViewModelFactoryProvider(application, noteRepository)


        noteViewModel = ViewModelProvider(
            this,
            viewModelFactoryProvider
        )[NoteViewModel::class.java]
    }


}