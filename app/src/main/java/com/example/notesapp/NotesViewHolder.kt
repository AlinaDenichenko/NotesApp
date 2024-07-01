package com.example.notesapp

import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.databinding.ItemNotesBinding
import com.example.notesapp.utils.format

class NotesViewHolder(private val binding: ItemNotesBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(note: Note) {
        binding.titleNote.text = note.title
        binding.descriptionNote.text = note.description
        binding.dateNote.text = note.date.format()
    }
}