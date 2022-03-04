package com.gruposinai.jefederuta.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.gruposinai.jefederuta.R
import com.gruposinai.jefederuta.databinding.FragmentNewClientAddressBinding
import com.gruposinai.jefederuta.model.ClientViewModel

class NewClientAddressFragment : Fragment() {

    private val sharedViewModel: ClientViewModel by activityViewModels()
    private lateinit var binding: FragmentNewClientAddressBinding

    //Fields
    private lateinit var address: String
    private lateinit var suburb: String
    private lateinit var postalCode: String
    private lateinit var city: String
    private lateinit var state: String

    //TextLayout and EditText
    private val textLayoutClientAddress: TextInputLayout by lazy { binding.textLayoutClientAddress }
    private val editTextClientAddress: TextInputEditText by lazy { binding.editTexClientAddress }
    private val textLayoutClientSuburb: TextInputLayout by lazy { binding.textLayoutClientSuburb }
    private val editTextClientSuburb: TextInputEditText by lazy { binding.editTexClientSuburb }
    private val textLayoutClientCP: TextInputLayout by lazy { binding.textLayoutClientCp }
    private val editTextClientCP: TextInputEditText by lazy { binding.editTexClientCp }
    private val textLayoutClientCity: TextInputLayout by lazy { binding.textLayoutClientCity }
    private val editTextClientCity: TextInputEditText by lazy { binding.editTexClientCity }
    private val textLayoutClientState: TextInputLayout by lazy { binding.textLayoutClientState }
    private val editTextClientState: TextInputEditText by lazy { binding.editTexClientState }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewClientAddressBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            sharedViewModel = this@NewClientAddressFragment.sharedViewModel
            saveButton.setOnClickListener { saveClient() }
            cancelButton.setOnClickListener { cancel() }
        }
    }

    private fun saveClient(){
        //Fields to address
        address = editTextClientAddress.text.toString()
        suburb = editTextClientSuburb.text.toString()
        postalCode = editTextClientCP.text.toString()
        city = editTextClientCity.text.toString()
        state = editTextClientState.text.toString()
        //Booleans to verify fields state
        val isValidAddress = address.isNotEmpty()
        val isValidSuburb = suburb.isNotEmpty()
        val isValidPostalCode = postalCode.isNotEmpty()
        val isValidCity = city.isNotEmpty()
        val isValidState = state.isNotEmpty()

        setErrorClientAddress(isValidAddress)
        setErrorClientSuburb(isValidSuburb)
        setErrorClientCP(isValidPostalCode)
        setErrorClientCity(isValidCity)
        setErrorClientState(isValidState)

        if(isValidAddress && isValidSuburb && isValidPostalCode && isValidCity && isValidState){
            sharedViewModel.setAddress(address, suburb, postalCode, city, state)
            sharedViewModel.addClient()
            findNavController().navigate(R.id.action_newClientAddressFragment_to_clientListFragment)
        }

    }

    private fun setErrorClientAddress(isValid: Boolean){
        if(!isValid){
            textLayoutClientAddress.isErrorEnabled = true
            textLayoutClientAddress.error = getString(R.string.required_field)
        }else{
            textLayoutClientAddress.isErrorEnabled = false
            textLayoutClientAddress.error = null
        }
    }

    private fun setErrorClientSuburb(isValid: Boolean){
        if(!isValid){
            textLayoutClientSuburb.isErrorEnabled = true
            textLayoutClientSuburb.error = getString(R.string.required_field)
        }else{
            textLayoutClientSuburb.isErrorEnabled = false
            textLayoutClientSuburb.error = null
        }
    }

    private fun setErrorClientCP(isValid: Boolean){
        if(!isValid){
            textLayoutClientCP.isErrorEnabled = true
            textLayoutClientCP.error = getString(R.string.required_field)
        }else{
            textLayoutClientCP.isErrorEnabled = false
            textLayoutClientCP.error = null
        }
    }

    private fun setErrorClientCity(isValid: Boolean){
        if(!isValid){
            textLayoutClientCity.isErrorEnabled = true
            textLayoutClientCity.error = getString(R.string.required_field)
        }else{
            textLayoutClientCity.isErrorEnabled = false
            textLayoutClientCity.error = null
        }
    }

    private fun setErrorClientState(isValid: Boolean){
        if(!isValid){
            textLayoutClientState.isErrorEnabled = true
            textLayoutClientState.error = getString(R.string.required_field)
        }else{
            textLayoutClientState.isErrorEnabled = false
            textLayoutClientState.error = null
        }
    }

    private fun cancel(){
        sharedViewModel.resetDates()
        findNavController().navigate(R.id.action_newClientAddressFragment_to_clientListFragment)
    }

}