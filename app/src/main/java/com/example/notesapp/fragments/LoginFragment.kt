package com.example.notesapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.example.notesapp.databinding.FragmentLoginBinding
import com.google.android.material.textfield.TextInputLayout
import com.example.notesapp.R

class LoginFragment : Fragment() {

    private var binding: FragmentLoginBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editHelperText(binding?.emailEditText, binding?.emailInputLayout)
        editHelperText(binding?.passwordEditText, binding?.passwordInputLayout)

        binding?.emailEditText?.doAfterTextChanged {
            enableButton(
                listOf(binding?.emailEditText, binding?.passwordEditText),
                binding?.loginButton
            )
        }

        binding?.passwordEditText?.doAfterTextChanged {
            enableButton(
                listOf(binding?.emailEditText, binding?.passwordEditText),
                binding?.loginButton
            )
        }

        binding?.returnToSignupButton?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, SignUpFragment())
                .addToBackStack(null)
                .commit()
        }

        binding?.loginButton?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, NotesListFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    private fun editHelperText(editText: EditText?, inputLayout: TextInputLayout?) {
        editText?.doAfterTextChanged {
            when (editText.text.isNotBlank()) {
                true -> inputLayout?.helperText = ""
                false -> inputLayout?.helperText = getString(R.string.required)
            }
        }
    }

    private fun enableButton(editTextList: List<EditText?>, button: Button?) {
        button?.isEnabled = editTextList[0]?.text.toString().isNotBlank() &&
                editTextList[1]?.text.toString().isNotBlank()
    }
}