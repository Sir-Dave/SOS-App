package com.sirdave.sosapp.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sirdave.sosapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavView = findViewById(R.id.bottom_nav_view)

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_camera, R.id.navigation_contact_list
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNavView.setupWithNavController(navController)
        setupNavigation(navController)
    }

    private fun setupNavigation(navController: NavController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.navigation_home -> {
                    supportActionBar?.hide()
                    showBottomNav()
                }
                R.id.navigation_camera -> {
                    supportActionBar?.hide()
                    showBottomNav()
                }

                R.id.navigation_contact_list -> {
                    supportActionBar?.hide()
                    showBottomNav()
                }
                else -> {
                    supportActionBar?.show()
                    hideBottomNav()
                }
            }
        }
    }

    private fun showBottomNav() {
        bottomNavView.visibility = View.VISIBLE
    }

    private fun hideBottomNav() {
        bottomNavView.visibility = View.GONE
    }
}