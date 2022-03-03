package com.gruposinai.jefederuta.data

import com.gruposinai.jefederuta.model.Client
import com.gruposinai.jefederuta.model.User
import java.util.*

class Data {
    companion object{
        val clients = mutableListOf(
            Client(UUID.randomUUID().toString(), "Yooys",null, true, false, "",
                "Av. Hector Perez Martínez","Revolución",
                24350, "Escárcega", "Campeche"),
            Client(UUID.randomUUID().toString(), "All Express",null, true, false, "",
                "Av. Justo Sierra Méndez","Revolución",
                24350, "Escárcega", "Campeche"),
            Client(UUID.randomUUID().toString(), "Michoacanos","Michoacanos de la Revolución", true, true, "",
                "49 entre 23 y 25","Revolución",
                24350, "Escárcega", "Campeche"),
            Client(UUID.randomUUID().toString(), "Abarrotes Ojeda","Wero", true, true, "",
                "Av. Concordia","Fátima",
                24350, "Escárcega", "Campeche")
        )
    }
}

val userList = listOf(
    User("Domingo Cabrera", "domingo.c@gruposinai.com.mx","domingo"),
    User("Manuel Ricardez", "manuel.r@gruposinai.com.mx","manuel"),
    User("Alberto Contreras", "betocontreras@sinai.mx", "a")
)