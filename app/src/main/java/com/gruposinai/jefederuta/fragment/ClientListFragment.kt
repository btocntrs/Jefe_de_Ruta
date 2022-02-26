package com.gruposinai.jefederuta.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.gruposinai.jefederuta.adapter.ClientItemAdapter
import com.gruposinai.jefederuta.databinding.FragmentClientListBinding


class ClientListFragment : Fragment() {

    private lateinit var binding: FragmentClientListBinding
    private lateinit var clientsRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentClientListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.clientListRecyclerView.adapter = ClientItemAdapter()
        binding.clientListRecyclerView.setHasFixedSize(true)
    }

}