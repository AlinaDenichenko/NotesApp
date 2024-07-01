package com.example.notesapp.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun LocalDate.format(): String {
    return this.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
}