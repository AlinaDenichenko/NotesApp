package com.example.notesapp.validation

import java.util.regex.Matcher
import java.util.regex.Pattern

object Validation {

    fun nameValidation(name: String?): Boolean {
        return !(name?.length!! < 3 || name.length > 255)
    }

    fun emailValidation(email: String?): Boolean {
        val emailPattern: Pattern = Pattern.compile("[a-zA-Z0-9._-]+@[a-z_-]+.{1}[a-z]+")
        val matcher: Matcher? = email?.let { emailPattern.matcher(it) }
        val matches: Boolean = matcher?.matches() ?: true
        return matches
    }

    fun passwordValidation(password: String?): Boolean {
        val passwordPattern: Pattern =
            Pattern.compile("(?=.*[0-9])(?=.*[!@#\$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#\$%^&*]{6,50}")
        val matcher: Matcher? = password?.let { passwordPattern.matcher(it) }
        val matches: Boolean = matcher?.matches() ?: true
        return matches
    }
}