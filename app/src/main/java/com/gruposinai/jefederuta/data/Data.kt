package com.gruposinai.jefederuta.data

import com.gruposinai.jefederuta.model.Client
import com.gruposinai.jefederuta.model.User
import java.util.*

val userList = listOf(
    User("Domingo Cabrera", "domingo.c@gruposinai.com.mx","domingo"),
    User("Manuel Ricardez", "manuel.r@gruposinai.com.mx","manuel"),
    User("Alberto Contreras", "betocontreras@sinai.mx", "a")
)

val clients = listOf(
    Client(UUID.randomUUID().toString(), "Yooys",null,
        "Av. Hector Perez Martínez",null,null,"Revolución",
        24350, "Escárcega", "Campeche"),
    Client(UUID.randomUUID().toString(), "All Express",null,
        "Av. Justo Sierra Méndez",null,null,"Revolución",
        24350, "Escárcega", "Campeche"),
    Client(UUID.randomUUID().toString(), "Michoacanos","Michoacanos de la Revolución",
        "49 entre 23 y 25",null,null,"Revolución",
        24350, "Escárcega", "Campeche"),
    Client(UUID.randomUUID().toString(), "Abarrotes Ojeda","Wero",
        "Av. Concordia","23-A",null,"Fátima",
        24350, "Escárcega", "Campeche")
)