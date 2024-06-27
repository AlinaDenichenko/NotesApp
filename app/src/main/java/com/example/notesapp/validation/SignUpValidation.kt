package com.example.notesapp.validation

import com.example.notesapp.exceptions.EmailInvalidException
import com.example.notesapp.exceptions.NameLengthException
import com.example.notesapp.exceptions.PasswordInvalidException
import java.util.regex.Matcher
import java.util.regex.Pattern

class SignUpValidation {
    companion object {
        fun nameValidation(name: String) {
            if (name.length < 3 || name.length > 255) {
                throw NameLengthException()
            }
        }

        fun emailValidation(email: String) {
            val emailPattern: Pattern = Pattern.compile("[a-zA-Z0-9._-]+@[a-z_-]+.[a-z]+")
            val matcher: Matcher = emailPattern.matcher(email)
            val matches: Boolean = matcher.matches()
            if (!matches) {
                throw EmailInvalidException()
            }
        }

        fun passwordValidation(password: String) {
            val passwordPattern: Pattern =
                Pattern.compile("/(?=.*[0-9])(?=.*[!@#\$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#\$%^&*]{6,}/g")
            val matcher: Matcher = passwordPattern.matcher(password)
            val matches: Boolean = matcher.matches()
            if (!matches) {
                throw PasswordInvalidException()
            }
        }
    }
}