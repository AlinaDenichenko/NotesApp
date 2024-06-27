package com.example.notesapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.databinding.ActivityAddNoteBinding
import com.example.notesapp.exceptions.EmptyFieldException
import com.example.notesapp.utils.format

import com.example.notesapp.validation.FieldValidation
import java.time.Instant
import java.time.LocalDate
import java.util.Calendar

class AddNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val addButton = binding.addNoteButton
        val titleNoteEditText = binding.titleAddNote
        val descriptionNoteEditText = binding.descriptionAddNote
        val datePicker = binding.datePicker

        addButton.setOnClickListener {
            try {
                FieldValidation.IsEmpty(titleNoteEditText.text.toString())
                FieldValidation.IsEmpty(descriptionNoteEditText.text.toString())
                val date = LocalDate.of(datePicker.year, datePicker.month, datePicker.dayOfMonth)
                ListNotes.list.add(
                    Notes(
                        title = titleNoteEditText.text.toString(),
                        description = descriptionNoteEditText.text.toString(),
                        date = date
                    )
                )
                startActivity(Intent(this, NotesListActivity::class.java))
            } catch (e: EmptyFieldException) {
                Toast.makeText(this, "Empty field", LENGTH_LONG).show()
            }
        }
    }


}