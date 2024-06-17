package com.example.notesapp.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun LocalDate.format(): String {
    return this.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
}