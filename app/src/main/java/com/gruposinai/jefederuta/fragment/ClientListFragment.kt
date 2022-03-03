package com.gruposinai.jefederuta.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gruposinai.jefederuta.R
import com.gruposinai.jefederuta.adapter.ClientItemAdapter
import com.gruposinai.jefederuta.databinding.FragmentClientListBinding


class ClientListFragment : Fragment() {

    private lateinit var binding: FragmentClientListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentClientListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.apply {
            clientListRecyclerView.adapter = ClientItemAdapter()
            clientListRecyclerView.setHasFixedSize(true)

            newClientButton.setOnClickListener { newClientForm() }
        }
    }

    private fun newClientForm(){
        findNavController().navigate(R.id.action_clientListFragment_to_newClientNameFragment)
    }

}