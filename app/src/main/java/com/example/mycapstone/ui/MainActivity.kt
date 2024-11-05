package com.example.mycapstone.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mycapstone.R
import com.example.mycapstone.camera.CameraActivity
//import com.example.mycapstone.camera.CameraActivity
import com.example.mycapstone.databinding.ActivityMainBinding
//import com.example.mycapstone.history.HistoryActivity
//import com.example.mycapstone.news.NewsActivity
import com.example.mycapstone.profile.ProfileActivity
import com.example.mycapstone.recomendation.RecommendationActivity
import com.example.mycapstone.history.HistoryActivity
import com.example.mycapstone.news.NewsFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var currentImageUri: Uri? = null

//    private fun allPermissionsGranted() =
//        ContextCompat.checkSelfPermission(
//            this,
//            REQUIRED_PERMISSION
//        ) == PackageManager.PERMISSION_GRANTED

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("MainActivity", "Error inflating layout: ${e.message}")
        }

        setSupportActionBar(binding.toolbar)
        loadFragment(NewsFragment())



        // Bottom bar navigation
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    loadFragment(NewsFragment())
                    true
                }
                R.id.navigation_history -> {
                    val intent = Intent(this, HistoryActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_camera -> {
                    val intent = Intent(this, CameraActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_recomendation -> {
                    val intent = Intent(this, RecommendationActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_profile -> {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}