package com.mzm.movieepoxy.feature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mzm.movieepoxy.R
import com.mzm.movieepoxy.databinding.ActivityMainBinding
import com.mzm.movieepoxy.utils.setupWithNavController
import com.mzm.moviegoplay.core.util.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

//    private var currentNavController: LiveData<NavController>? = null
//    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setContentView(binding.root)

//        //use viewBinding
//        binding.bottomNavigationView.setOnItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.homeFragment -> {
//
//                }
//            }
//            true
//        }
//        old way
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.container)
        bottomNavigationView.setupWithNavController(navController)

//        setupNavigationbar()
    }

//    private fun setupNavigationbar() {
//        val bottomNavigationView = binding.bottomNavigationView
//        val navGraphIds = listOf(R.navigation.mobile_navigation)
//
//        // Setup the bottom navigation view with a list of navigation graphs
//        val controller = bottomNavigationView.setupWithNavController(
//            navGraphIds = navGraphIds,
//            fragmentManager = supportFragmentManager,
//            containerId = R.id.container,
//            intent = intent
//        )
//
//        // Whenever the selected controller changes, setup the action bar.
//        controller.observe(this, Observer { navController ->
//            setupActionBarWithNavController(navController)
//        })
//        currentNavController = controller
//    }
//
//    override fun onSupportNavigateUp(): Boolean {
//        return currentNavController?.value?.navigateUp() ?: false
//    }

}