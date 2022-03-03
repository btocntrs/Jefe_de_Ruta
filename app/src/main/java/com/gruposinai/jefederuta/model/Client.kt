package com.gruposinai.jefederuta.model

import kotlin.reflect.KProperty

data class Client(
    val clientID: String,
    var name: String,
    var alias: String?,
    var iceBuyer: Boolean,
    var waterBuyer: Boolean,
    var customerType: String,
    var address: String,
    var suburb: String,
    var cp: Int,
    var city: String,
    var state: String
){
    val fullAddress: String by FullAddress()

    override fun equals(other: Any?): Boolean {
        val otherClient = other as Client
        return this.clientID == otherClient.clientID
    }

    override fun hashCode(): Int {
        var result = clientID.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + (alias?.hashCode() ?: 0)
        result = 31 * result + iceBuyer.hashCode()
        result = 31 * result + waterBuyer.hashCode()
        result = 31 * result + customerType.hashCode()
        result = 31 * result + address.hashCode()
        result = 31 * result + suburb.hashCode()
        result = 31 * result + cp
        result = 31 * result + city.hashCode()
        result = 31 * result + state.hashCode()
        return result
    }

    class FullAddress{
        operator fun getValue(client: Client, property: KProperty<*>): String {
            return buildString {
                append("${client.address},")
                append(" Colonia ${client.suburb};")
                append(" CP ${client.cp};")
                append(" ${client.city},")
                append(" ${client.state}.")
            }
        }
    }

}