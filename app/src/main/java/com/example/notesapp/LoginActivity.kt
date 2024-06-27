package com.example.notesapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.notesapp.databinding.ActivityLoginBinding
import com.example.notesapp.exceptions.EmailInvalidException
import com.example.notesapp.exceptions.PasswordInvalidException
import com.example.notesapp.validation.LogInValidation

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val returnToSignUpButton = binding.returnToSignupButton
        val logInButton = binding.loginButton
        val email = binding.email
        val password = binding.password

        returnToSignUpButton.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
        email.setOnClickListener {
            email.text.clear()
        }
        password.setOnClickListener {
            password.text.clear()
        }
        logInButton.setOnClickListener {
            try {
                LogInValidation.emailValidation(email.text.toString())
                LogInValidation.passwordValidation(password.text.toString())
            } catch (e: EmailInvalidException) {
                Toast.makeText(this, "Invalid email", Toast.LENGTH_LONG).show()
            } catch (e: PasswordInvalidException) {
                Toast.makeText(this, "Invalid password", Toast.LENGTH_LONG).show()
            }
            startActivity(Intent(this, NotesListActivity::class.java))
        }
    }
}