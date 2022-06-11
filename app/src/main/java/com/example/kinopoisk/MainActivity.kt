package com.example.kinopoisk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.NavHost
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.kinopoisk.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val navController by lazy {
        (supportFragmentManager.findFragmentById(R.id.container) as NavHost)
            .navController
    }
    private var _binding: ActivityMainBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController)
        binding.bottomMenu.setupWithNavController(navController)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return false
    }
}