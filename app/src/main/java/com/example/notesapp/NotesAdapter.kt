package com.example.notesapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.databinding.ItemNotesBinding

class NotesAdapter(
    val listNotes: MutableList<Notes>,
    val onClick: (note: Notes) -> Unit
) : ListAdapter<Notes, NotesViewHolder>(NoteDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(
            ItemNotesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = listNotes.size

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.bind(listNotes[position])
        listNotes[position].run {
            holder.bind(this)
            holder.itemView.setOnClickListener {
                onClick(this)
            }
        }
    }
}