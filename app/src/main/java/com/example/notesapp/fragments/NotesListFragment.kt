package com.example.notesapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notesapp.NotesAdapter
import com.example.notesapp.NotesList
import com.example.notesapp.R
import com.example.notesapp.databinding.FragmentNotesBinding

class NotesListFragment : Fragment() {

    private var binding: FragmentNotesBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotesBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.listNotes?.run {
            adapter = NotesAdapter(NotesList.list) {
                it.findViewById<TextView>(R.id.description_note).maxLines = Int.MAX_VALUE
            }
                .apply {
                    submitList(NotesList.list)
                }
            layoutManager = LinearLayoutManager(requireContext())
        }

        binding?.addNoteButton?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, AddNoteFragment())
                .addToBackStack(null)
                .commit()
        }

        binding?.logOutButton?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}