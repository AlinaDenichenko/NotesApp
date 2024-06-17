package com.example.notesapp.validation

import com.example.notesapp.exceptions.EmptyFieldException

class FieldValidation {
    companion object {
        fun IsEmpty(text: String) {
            if (text.isBlank()) {
                throw EmptyFieldException()
            }
        }
    }
}