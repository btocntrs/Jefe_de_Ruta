package com.gruposinai.jefederuta.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gruposinai.jefederuta.data.Data.Companion.clients

class ClientViewModel: ViewModel() {

    private val clientList = clients

    private val _name = MutableLiveData<String>("")
    val name: LiveData<String> = _name

    private val _alias = MutableLiveData<String>("")
    val alias: LiveData<String> = _alias

    private val _iceBuyer = MutableLiveData<Boolean>(false)
    val iceBuyer: LiveData<Boolean> = _iceBuyer

    private val _waterBuyer = MutableLiveData<Boolean>(false)
    val waterBuyer: LiveData<Boolean> = _waterBuyer

    private val _customerType = MutableLiveData<String>("")
    val customerType: LiveData<String> = _customerType

    fun setName(name: String){
        _name.value = name
    }

    fun setAlias(alias: String){
        _alias.value = alias
    }

    fun setIceBuyer(isIceBuyer: Boolean){
        _iceBuyer.value = isIceBuyer
    }

    fun setWaterBuyer(isWaterBuyer: Boolean){
        _waterBuyer.value = isWaterBuyer
    }

    fun setCustomerType(typeSelected: String){
        _customerType.value = typeSelected
    }

    fun hasNoCustomerTypeSet(): Boolean{
        return _customerType.value.isNullOrEmpty()
    }

    fun addClient(newClient: Client){
        clientList.add(newClient)
    }

}