package com.gruposinai.jefederuta.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gruposinai.jefederuta.data.Data.Companion.clients
import java.util.*

class ClientViewModel: ViewModel() {

    private val clientList = clients
    private val newClient = Client(
            UUID.randomUUID().toString(),
            name = "",
            alias = "",
            iceBuyer = false,
            waterBuyer = false,
            customerType = "",
            address = "",
            suburb = "",
            postalCode = -1,
            city = "",
            state = ""
        )

    private val _name = MutableLiveData("")
    val name: LiveData<String> = _name

    private val _alias = MutableLiveData("")
    val alias: LiveData<String> = _alias

    private val _iceBuyer = MutableLiveData(false)
    val iceBuyer: LiveData<Boolean> = _iceBuyer

    private val _waterBuyer = MutableLiveData(false)
    val waterBuyer: LiveData<Boolean> = _waterBuyer

    private val _customerType = MutableLiveData("")
    val customerType: LiveData<String> = _customerType

    private val _address = MutableLiveData("")
    val address: LiveData<String> = _address

    private val _suburb = MutableLiveData("")
    val suburb: LiveData<String> = _suburb

    private val _postalCode = MutableLiveData("")
    val postalCode: LiveData<String> = _postalCode

    private val _city = MutableLiveData("")
    val city: LiveData<String> = _city

    private val _state = MutableLiveData("")
    val state: LiveData<String> = _state

    fun setName(name: String){
        _name.value = name
        newClient.name = name
    }

    fun setAlias(alias: String){
        _alias.value = alias
        newClient.alias = alias
    }

    fun setIceBuyer(isIceBuyer: Boolean){
        _iceBuyer.value = isIceBuyer
        newClient.iceBuyer = isIceBuyer
    }

    fun setWaterBuyer(isWaterBuyer: Boolean){
        _waterBuyer.value = isWaterBuyer
        newClient.waterBuyer = isWaterBuyer
    }

    fun setCustomerType(typeSelected: String){
        _customerType.value = typeSelected
        newClient.customerType = typeSelected
    }

    fun setAddress(address: String, suburb: String, postalCode: String, city: String, state: String){
        _address.value = address
        newClient.address = address

        _suburb.value = suburb
        newClient.suburb = suburb

        _postalCode.value = postalCode
        newClient.postalCode = postalCode.toInt()

        _city.value = city
        newClient.city = city

        _state.value = state
        newClient.state = state
    }

    fun hasNoCustomerTypeSet(): Boolean{
        return _customerType.value.isNullOrEmpty()
    }

    fun addClient(newClient: Client){
        clientList.add(newClient)
    }

    fun addClient(){
        clientList.add(newClient)
    }

    fun getClient(): Client{
        return newClient
    }

    fun resetDates(){
        _name.value = ""
        _alias.value = ""
        _iceBuyer.value = false
        _waterBuyer.value = false
        _customerType.value = ""
        _address.value = ""
        _suburb.value = ""
        _postalCode.value = ""
        _city.value = ""
        _state.value = ""
    }

}