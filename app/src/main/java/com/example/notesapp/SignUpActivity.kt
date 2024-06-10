package com.example.notesapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.notesapp.exceptions.EmailInvalidException
import com.example.notesapp.exceptions.NameLengthException
import com.example.notesapp.exceptions.PasswordInvalidException
import com.example.notesapp.validation.SignUpValidation

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        val loginButton = findViewById<Button>(R.id.login_button)
        val signupButton = findViewById<Button>(R.id.signup_button)
        val firstName = findViewById<EditText>(R.id.first_name)
        val lastName = findViewById<EditText>(R.id.last_name)
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)

        loginButton.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        firstName.setOnClickListener {
            firstName.text.clear()
        }
        lastName.setOnClickListener {
            lastName.text.clear()
        }
        email.setOnClickListener {
            email.text.clear()
        }
        password.setOnClickListener {
            password.text.clear()
        }

        signupButton.setOnClickListener {
            try {
                SignUpValidation.nameValidation(firstName.text.toString())
                SignUpValidation.nameValidation(lastName.text.toString())
                SignUpValidation.emailValidation(email.text.toString())
                SignUpValidation.passwordValidation(password.text.toString())
            } catch (e: NameLengthException) {
                Toast.makeText(this, "Invalid name", Toast.LENGTH_LONG).show()
            } catch (e: EmailInvalidException) {
                Toast.makeText(this, "Invalid email", Toast.LENGTH_LONG).show()
            } catch (e: PasswordInvalidException) {
                Toast.makeText(this, "Invalid password", Toast.LENGTH_LONG).show()
            }
        }
    }
}