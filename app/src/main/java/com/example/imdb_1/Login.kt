package com.example.imdb_1

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import org.intellij.lang.annotations.Pattern


class Login : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_login, container, false)

        val loginButton = root.findViewById<Button>(R.id.loginButton)

        loginButton.isEnabled = false
        val emailField = root.findViewById<TextView>(R.id.username)
        val passwordField = root.findViewById<TextView>(R.id.password)
        val createAccount = root.findViewById<TextView>(R.id.signupButton)

        createAccount.setOnClickListener {
            findNavController().navigate(LoginDirections.actionLoginToSignup())
        }

        emailField.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val formValidation : Boolean = validateLoginForm(emailField.text.toString(), passwordField.text.toString())
                if (formValidation) loginButton.setBackgroundResource(R.drawable.dark_gray_button)
                else loginButton.setBackgroundResource(R.drawable.light_gray_button)
            }

            override fun afterTextChanged(s: Editable?) {

                val formValidation : Boolean = validateLoginForm(emailField.text.toString(), passwordField.text.toString())
                Log.e(">>>>>>>", formValidation.toString())
                if (formValidation) loginButton.setBackgroundResource(R.drawable.dark_gray_button)
                else loginButton.setBackgroundResource(R.drawable.light_gray_button)
            }

        })

        passwordField.addTextChangedListener( object :  TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val formValidation : Boolean = validateLoginForm(emailField.text.toString(), passwordField.text.toString())
                if (formValidation) {
                    loginButton.setBackgroundResource(R.drawable.dark_gray_button)
                    loginButton.isEnabled = true
                }
                else{
                    loginButton.setBackgroundResource(R.drawable.light_gray_button)
                    loginButton.isEnabled = false
                }
            }

            override fun afterTextChanged(s: Editable?) {
                val formValidation : Boolean = validateLoginForm(emailField.text.toString(), passwordField.text.toString())
                if (formValidation) loginButton.setBackgroundResource(R.drawable.dark_gray_button)
                else loginButton.setBackgroundResource(R.drawable.light_gray_button)
            }

        })


        loginButton.setOnClickListener{
            findNavController().navigate(LoginDirections.actionLoginToSearch())
        }
        return root
    }



    private fun validateLoginForm(email: String, password: String) : Boolean  {
        return (validateEmail(email) && validatePassword(password))
    }
    private fun validateEmail( email : String):Boolean {
        return email.contains("@")
    }

    private fun validatePassword(password : String) : Boolean {
        return password.length >= 8
    }

}