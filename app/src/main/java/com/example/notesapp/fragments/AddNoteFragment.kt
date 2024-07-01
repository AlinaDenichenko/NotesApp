package com.example.notesapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.example.notesapp.Note
import com.example.notesapp.NotesList
import com.example.notesapp.R
import com.example.notesapp.databinding.FragmentAddNoteBinding

import java.time.LocalDate

class AddNoteFragment : Fragment() {

    private var binding: FragmentAddNoteBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val datePicker = binding?.datePicker

        binding?.addTitleNoteEditText?.doAfterTextChanged {
            enableButton(listOf(
                binding?.addDescriptionNoteEditText,
                binding?.addTitleNoteEditText
            ), binding?.addNoteButton)
        }

        binding?.addDescriptionNoteEditText?.doAfterTextChanged {
            enableButton(listOf(
                binding?.addDescriptionNoteEditText,
                binding?.addTitleNoteEditText
            ), binding?.addNoteButton)
        }

        binding?.addNoteButton?.setOnClickListener {
            val date =
                datePicker?.year?.let { it1 ->
                    datePicker?.month?.let { it2 ->
                        datePicker?.dayOfMonth?.let { it3 ->
                            LocalDate.of(
                                it1,
                                it2, it3
                            )
                        }
                    }
                }
            date?.let {
                Note(
                    title = binding?.addTitleNoteEditText?.text.toString(),
                    description = binding?.addDescriptionNoteEditText?.text.toString(),
                    date = it
                )
            }?.let {
                NotesList.list.add(
                    it
                )
            }
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, NotesListFragment())
                .addToBackStack(null)
                .commit()
        }

        binding?.backButton?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, NotesListFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    private fun enableButton(editTextList: List<EditText?>, button: Button?) {
        button?.isEnabled = editTextList[0]?.text.toString().isNotBlank() &&
                editTextList[1]?.text.toString().isNotBlank()
    }
}