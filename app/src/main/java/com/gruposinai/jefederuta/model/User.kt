package com.gruposinai.jefederuta.model

data class User(
    var userName: String,
    var email: String,
    var password: String
){
    override fun equals(other: Any?): Boolean {
        val otherUser = other as User
        return this.email == otherUser.email
    }

    override fun hashCode(): Int {
        var result = userName.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + password.hashCode()
        return result
    }

}