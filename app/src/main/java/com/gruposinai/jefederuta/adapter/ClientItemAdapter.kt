package com.gruposinai.jefederuta.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gruposinai.jefederuta.R
import com.gruposinai.jefederuta.data.clients

class ClientItemAdapter: RecyclerView.Adapter<ClientItemAdapter.ClientViewHolder>() {

    private val clientList = clients

    class ClientViewHolder(view: View): RecyclerView.ViewHolder(view){
        val clientNameTextView: TextView = view.findViewById(R.id.client_name_text_view)
        val clientAddressTextView: TextView = view.findViewById(R.id.client_address_text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder {
        val layout: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.client_item, parent, false)

        return ClientViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {

        val client = clientList[position]

        holder.clientNameTextView.text = client.name
        holder.clientAddressTextView.text = client.fullAddress

    }

    override fun getItemCount() = clientList.size

}