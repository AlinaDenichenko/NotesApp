package com.example.notesapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.notesapp.exceptions.EmailInvalidException
import com.example.notesapp.exceptions.PasswordInvalidException
import com.example.notesapp.validation.LogInValidation

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val returnToSignUpButton = findViewById<Button>(R.id.return_to_signup_button)
        val logInButton = findViewById<Button>(R.id.login_button)
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)

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
        }
    }
}