package com.gruposinai.jefederuta.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.gruposinai.jefederuta.R
import com.gruposinai.jefederuta.databinding.FragmentNewClientNameBinding
import com.gruposinai.jefederuta.model.ClientViewModel

class NewClientNameFragment : Fragment() {

    private val sharedViewModel: ClientViewModel by activityViewModels()
    private lateinit var binding: FragmentNewClientNameBinding

    private lateinit var name: String
    private lateinit var alias: String
    //Inputs texts
    private val textInputLayoutClientName: TextInputLayout by lazy { binding.textLayoutClientName }
    private val textInputLayoutClientAlias: TextInputLayout by lazy { binding.textLayoutClientAlias }
    private val editTextClientName: TextInputEditText by lazy { binding.editTexClientName }
    private val editTextClientAlias: TextInputEditText by lazy { binding.editTextClientAlias }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewClientNameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            sharedViewModel = this@NewClientNameFragment.sharedViewModel
            nextButton.setOnClickListener { next() }
            cancelButton.setOnClickListener { cancel() }
        }
    }

    private fun next(){
        name = editTextClientName.text.toString()
        alias = editTextClientAlias.text.toString()
        val isValidClientName = name.isNotEmpty()
        val isValidClientAlias = alias.isNotEmpty()

        if (isValidClientName && isValidClientAlias){
            sharedViewModel.setName(name)
            sharedViewModel.setAlias(alias)

            if(sharedViewModel.hasNoCustomerTypeSet()){
                sharedViewModel.setCustomerType(getString(R.string.private_client))
            }

            findNavController().navigate(R.id.action_newClientNameFragment_to_newClientTypeFragment)
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
            textInputLayoutClientName.error = null
        }
    }

    private fun setErrorClientAlias(isValid: Boolean){
        if(!isValid){
            textInputLayoutClientAlias.isErrorEnabled = true
            textInputLayoutClientAlias.error = getString(R.string.required_field)
        }else{
            textInputLayoutClientAlias.isErrorEnabled = false
            textInputLayoutClientAlias.error = null
        }
    }

    private fun cancel(){
        val action = NewClientNameFragmentDirections.actionNewClientNameFragmentToClientListFragment()
        findNavController().navigate(action)
    }

}