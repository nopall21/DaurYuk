package com.example.mycapstone.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.mycapstone.auth.login.LoginActivity
import com.example.mycapstone.auth.UserPreference
import com.example.mycapstone.auth.dataStore
import com.example.mycapstone.databinding.ActivityProfileBinding
import com.example.mycapstone.reward.RewardActivity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private lateinit var userPref: UserPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userPref = UserPreference.getInstance(applicationContext.dataStore)

        displayUsername()
        setupRewardButton()
        setupLogoutButton()
    }

    private fun displayUsername() {
        lifecycleScope.launch {
            val username = userPref.username.first()
            binding.userNameTextView.text = username
        }
    }

    private fun setupRewardButton() {
        binding.rewardButton.setOnClickListener {
            val intent = Intent(this, RewardActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupLogoutButton() {
        binding.logoutButton.setOnClickListener {
            clearLoginState()
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }

    private fun clearLoginState() {
        lifecycleScope.launch {
            userPref.clearPreferences()
        }
    }
}