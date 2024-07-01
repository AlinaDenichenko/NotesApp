package com.example.notesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import com.example.notesapp.databinding.FragmentNotesBinding
import com.example.notesapp.databinding.ItemNotesBinding

class NotesAdapter(
    private val listNotes: MutableList<Note>,
    val onClick: (view: View) -> Unit
) : ListAdapter<Note, NotesViewHolder>(NoteDiffUtil()) {
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
        holder.bind(getItem(position))
        listNotes[position].run {
            holder.bind(this)
            holder.itemView.setOnClickListener {
                onClick(it)
            }
        }
    }
}
