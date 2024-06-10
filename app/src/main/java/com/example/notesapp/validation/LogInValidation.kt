package com.example.notesapp.validation

import com.example.notesapp.exceptions.EmailInvalidException
import com.example.notesapp.exceptions.PasswordInvalidException

class LogInValidation {
    companion object {
        fun emailValidation(email: String) {
            if (email.isBlank()) {
                throw EmailInvalidException()
            }
        }

        fun passwordValidation(password: String) {
            if (password.isBlank()) {
                throw PasswordInvalidException()
            }
        }
    }
}