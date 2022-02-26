package com.gruposinai.jefederuta.model

import androidx.lifecycle.ViewModel
import com.gruposinai.jefederuta.data.userList

class LoginUserViewModel : ViewModel() {

    private val users = userList

    /**
     * Check is a user exist in the DB
     * @param user the user to verify in the DB
     * @return return true if user exists and false otherwise
     */
    fun userExist(user: User): Boolean{
        return users.contains(user)
    }


    private fun getRealUser(user: User) = users.filter { it.email == user.email }[0]

    /**
     * Check if the provided password is correct
     * @param userToVerify the user to verify
     * @return return true is the password is correct and false otherwise
     * */
    fun passwordIsCorrect(userToVerify: User): Boolean{
        val realUser = getRealUser(userToVerify)
        return realUser.password == userToVerify.password
    }

}