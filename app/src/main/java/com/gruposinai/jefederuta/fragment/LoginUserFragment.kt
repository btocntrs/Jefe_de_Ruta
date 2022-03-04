package com.gruposinai.jefederuta.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.gruposinai.jefederuta.ClientListActivity
import com.gruposinai.jefederuta.R
import com.gruposinai.jefederuta.databinding.FragmentLoginUserBinding
import com.gruposinai.jefederuta.model.LoginUserViewModel
import com.gruposinai.jefederuta.model.User

class LoginUserFragment : Fragment() {

    private val loginViewModel: LoginUserViewModel by viewModels()

    private lateinit var binding: FragmentLoginUserBinding
    private val singInButton: Button by lazy { binding.singInButton }

    private lateinit var user: User

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        singInButton.setOnClickListener { login() }
    }

    private fun login(){
        val userEmail = binding.textFieldEditUserEmail.text.toString()
        val userPassword = binding.textFieldEditUserPassword.text.toString()

        user = User("", userEmail, userPassword)

        if(loginViewModel.userExist(user)){
            if(loginViewModel.passwordIsCorrect(user)){
                val context = singInButton.context
                val intent = Intent(context, ClientListActivity::class.java)
                context.startActivity(intent)
            } else {
                setErrorUserEmailField(false)
                setErrorUserPasswordField()
            }
        } else {
            setErrorUserEmailField(true)
        }
    }

    /*
    * Sets and resets the text field error status.
    */
    private fun setErrorUserEmailField(error: Boolean) {
        if (error) {
            binding.textFieldUserEmail.isErrorEnabled = true
            binding.textFieldUserEmail.error = getString(R.string.invalid_email)
        } else {
            binding.textFieldUserEmail.isErrorEnabled = false
        }
    }

    /*
    * Sets and resets the text field error status.
    */
    private fun setErrorUserPasswordField() {
            binding.textFieldUserPassword.isErrorEnabled = true
            binding.textFieldUserPassword.error = getString(R.string.invalid_password)
    }

}