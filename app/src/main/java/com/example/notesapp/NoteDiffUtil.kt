package com.example.notesapp

import androidx.recyclerview.widget.DiffUtil

class NoteDiffUtil : DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return false
    }

}