package com.example.notesapp

import java.time.LocalDate

data class Note(
    val title: String,
    val description: String,
    val date: LocalDate
)