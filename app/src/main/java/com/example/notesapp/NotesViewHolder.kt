package com.example.notesapp

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.databinding.ItemNotesBinding
import com.example.notesapp.utils.format

class NotesViewHolder(val binding: ItemNotesBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(note: Notes) {
        binding.titleNote.text = note.title
        binding.descriptionNote.text = note.description
        binding.dateNote.text = note.date.format()
    }
}