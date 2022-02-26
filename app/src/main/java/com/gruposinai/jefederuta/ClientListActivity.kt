package com.gruposinai.jefederuta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.gruposinai.jefederuta.adapter.ClientItemAdapter

class ClientListActivity : AppCompatActivity() {

    companion object{
        const val DELiVERY_MAN = "delivery_man"
    }

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_list)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_client) as NavHostFragment
        navController = navHostFragment.navController

        setupActionBarWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}