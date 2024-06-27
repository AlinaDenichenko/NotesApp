package com.example.notesapp

import java.time.LocalDate

data class Notes(
    val title: String,
    val description: String,
    val date: LocalDate
)