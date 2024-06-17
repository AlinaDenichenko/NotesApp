package com.example.notesapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Note
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.IntegerRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.forEach
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.databinding.ActivityAddNoteBinding
import com.example.notesapp.databinding.ActivityNotesBinding
import com.example.notesapp.databinding.ItemNotesBinding

class NotesListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val recyclerView: RecyclerView = binding.listNotes
        val addButton = binding.addNoteButton
        val logOutButton = binding.logOutButton

        recyclerView.run {
            adapter = NotesAdapter(ListNotes.list) { note ->
                Toast.makeText(this@NotesListActivity, note.title, Toast.LENGTH_LONG).show()
                this.findViewById<TextView>(R.id.description_note).maxLines = Integer.MAX_VALUE
            }
                .apply {
                    submitList(ListNotes.list)
                }
            layoutManager = LinearLayoutManager(this@NotesListActivity)
        }
        addButton.setOnClickListener {
            startActivity(Intent(this, AddNoteActivity::class.java))
        }
        logOutButton.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}