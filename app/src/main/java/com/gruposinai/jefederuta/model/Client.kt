package com.gruposinai.jefederuta.model

import kotlin.reflect.KProperty

data class Client(
    val clientID: String,
    var name: String,
    var alias: String?,
    var street: String,
    var externalNumber: String?,
    var internalNumber: String?,
    var suburb: String,
    var cp: Int,
    var city: String,
    var state: String
){
    val fullAddress: String by FullAddrees()

    override fun equals(other: Any?): Boolean {
        val otherClient = other as Client
        return this.clientID == otherClient.clientID
    }

    override fun hashCode(): Int {
        var result = clientID.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + (alias?.hashCode() ?: 0)
        result = 31 * result + street.hashCode()
        result = 31 * result + (externalNumber?.hashCode() ?: 0)
        result = 31 * result + (internalNumber?.hashCode() ?: 0)
        result = 31 * result + suburb.hashCode()
        result = 31 * result + cp
        result = 31 * result + city.hashCode()
        result = 31 * result + state.hashCode()
        return result
    }

    class FullAddrees{
        operator fun getValue(client: Client, property: KProperty<*>): String {
            return buildString {
                append("${client.street},")

                if(!client.externalNumber.isNullOrEmpty()){
                    append(" ${client.externalNumber} Ext,")
                }

                if(!client.internalNumber.isNullOrEmpty()){
                    append(" ${client.internalNumber} Int,")
                }

                append(" Colonia ${client.suburb};")
                append(" CP ${client.cp};")
                append(" ${client.city},")
                append(" ${client.state}.")
            }
        }
    }

}