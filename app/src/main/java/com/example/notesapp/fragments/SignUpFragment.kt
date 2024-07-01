package com.example.notesapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.example.notesapp.R
import com.example.notesapp.databinding.FragmentSignupBinding
import com.example.notesapp.validation.Validation
import com.google.android.material.textfield.TextInputLayout

class SignUpFragment : Fragment() {

    private var binding: FragmentSignupBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignupBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listFieldIsValid = mutableListOf(false, false, false, false)

        binding?.lastNameEditText?.doAfterTextChanged {
            editHelperText(
                Validation.nameValidation(it.toString()),
                binding?.lastNameInputLayout,
                getString(R.string.minimum_three_characters)
            )
            listFieldIsValid[0] = Validation.nameValidation(it.toString())
            enableButton(listFieldIsValid, binding?.signupButton)
        }

        binding?.firstNameEditText?.doAfterTextChanged {
            editHelperText(
                Validation.nameValidation(it.toString()),
                binding?.firstNameInputLayout,
                getString(R.string.minimum_three_characters)
            )
            listFieldIsValid[1] = Validation.nameValidation(it.toString())
            enableButton(listFieldIsValid, binding?.signupButton)
        }

        binding?.emailEditText?.doAfterTextChanged {
            editHelperText(
                Validation.emailValidation(it.toString()),
                binding?.emailInputLayout,
                getString(R.string.email_format)
            )
            listFieldIsValid[2] = Validation.emailValidation(it.toString())
            enableButton(listFieldIsValid, binding?.signupButton)
        }

        binding?.passwordEditText?.doAfterTextChanged {
            editHelperText(
                Validation.passwordValidation(it.toString()),
                binding?.passwordInputLayout,
                getString(R.string.password_validator)
            )
            listFieldIsValid[3] = Validation.passwordValidation(it.toString())
            enableButton(listFieldIsValid, binding?.signupButton)
        }

        binding?.signupButton?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, NotesListFragment())
                .addToBackStack(null)
                .commit()
        }

        binding?.loginButton?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    private fun editHelperText(
        isValid: Boolean,
        inputLayout: TextInputLayout?,
        helperText: String
    ) {
        when (isValid) {
            true -> inputLayout?.helperText = ""
            false -> inputLayout?.helperText = helperText
        }
    }

    private fun enableButton(listFieldIsValid: MutableList<Boolean>, button: Button?) {
        button?.isEnabled = listFieldIsValid[0] && listFieldIsValid[1] &&
                listFieldIsValid[2] && listFieldIsValid[3]
    }
}
