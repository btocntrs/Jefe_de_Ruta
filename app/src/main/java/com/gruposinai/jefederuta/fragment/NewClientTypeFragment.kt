package com.gruposinai.jefederuta.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.gruposinai.jefederuta.R
import com.gruposinai.jefederuta.databinding.FragmentNewClientTypeBinding
import com.gruposinai.jefederuta.model.ClientViewModel

class NewClientTypeFragment : Fragment() {

    private val sharedViewModel: ClientViewModel by activityViewModels()
    private lateinit var binding: FragmentNewClientTypeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewClientTypeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            sharedViewModel = this@NewClientTypeFragment.sharedViewModel
            nextButton.setOnClickListener { nextScreen() }
        }
    }

    private fun nextScreen(){
        if(sharedViewModel.iceBuyer.value!! || sharedViewModel.waterBuyer.value!!){
            setErrorCustomerType(false)
            val template = "Ice = ${sharedViewModel.iceBuyer.value} - Water = ${sharedViewModel.waterBuyer.value}"
            Toast.makeText(context, template, Toast.LENGTH_LONG).show()

        } else {
            setErrorCustomerType(true)
        }
    }

    private fun setErrorCustomerType(error: Boolean){
        if(error){
            val errorMsg = getString(R.string.product_error)
            binding.errorTextView.error = errorMsg
            binding.errorTextView.text = errorMsg
        } else {
            binding.errorTextView.error = null
            binding.errorTextView.text = ""
        }
    }


}