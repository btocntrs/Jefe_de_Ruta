package com.gruposinai.jefederuta.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.gruposinai.jefederuta.R
import com.gruposinai.jefederuta.databinding.FragmentNewClientNameBinding

class NewClientNameFragment : Fragment() {

    private lateinit var binding: FragmentNewClientNameBinding

    //Inputs texts
    private val textInputLayoutClientName: TextInputLayout by lazy { binding.textLayoutClientName }
    private val textInputLayoutClientAlias: TextInputLayout by lazy { binding.textLayoutClientAlias }
    private val editTextClientName: TextInputEditText by lazy { binding.editTexClientName }
    private val editTextClientAlias: TextInputEditText by lazy { binding.editTextClientAlias }

    //Buttons
    private val nextButton: Button by lazy { binding.nextButton }
    private val cancelButton: Button by lazy { binding.cancelButton }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewClientNameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        nextButton.setOnClickListener { next() }
        cancelButton.setOnClickListener { cancel() }
    }

    private fun next(){
        val isValidClientName = editTextClientName.text.toString().isNotEmpty()
        val isValidClientAlias = editTextClientAlias.text.toString().isNotEmpty()

        if (isValidClientName && isValidClientAlias){
            Toast.makeText(context, "Next Form", Toast.LENGTH_LONG).show()
        } else {
            setErrorClientName(isValidClientName)
            setErrorClientAlias(isValidClientAlias)
        }
    }

    private fun setErrorClientName(isValid: Boolean){
        if(!isValid){
            textInputLayoutClientName.isErrorEnabled = true
            textInputLayoutClientName.error = getString(R.string.required_field)
        }else{
            textInputLayoutClientName.isErrorEnabled = false
        }
    }

    private fun setErrorClientAlias(isValid: Boolean){
        if(!isValid){
            textInputLayoutClientAlias.isErrorEnabled = true
            textInputLayoutClientAlias.error = getString(R.string.required_field)
        }else{
            textInputLayoutClientAlias.isErrorEnabled = false
        }
    }

    private fun cancel(){
        val action = NewClientNameFragmentDirections.actionNewClientNameFragmentToClientListFragment()
        findNavController().navigate(action)
    }

}