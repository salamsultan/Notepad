package com.example.notepad

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.notepad.database.Note
import com.example.notepad.databinding.NotelistBinding

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private var binding: NotelistBinding? = null


    class NoteViewHolder(itemBinding: NotelistBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

    private val differCallBack =
        object : DiffUtil.ItemCallback<Note>(){

            override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
                return oldItem == newItem
            }


        }

    private val differ = AsyncListDiffer(this, differCallBack)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {

        binding = NotelistBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)


        return NoteViewHolder(binding!!)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {

        val currentNote = differ.currentList[position]

         holder.itemView.apply {

            binding?.tvTitle?.text = currentNote.title
            binding?.tvNote?.text = currentNote.note
            binding?.tvDate?.text = currentNote.date
        }


    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }




}