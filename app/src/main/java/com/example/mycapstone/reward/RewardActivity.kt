package com.example.mycapstone.reward

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycapstone.databinding.ActivityRewardBinding
import com.example.mycapstone.reward.adapter.RewardAdapter

class RewardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRewardBinding
    private lateinit var rewardAdapter: RewardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRewardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupClaimPointsButton()
    }

    private fun setupRecyclerView() {
        val rewards = listOf(
            Reward(5000, "5.000 Pulsa"),
            Reward(10000, "10.000 Pulsa"),
            Reward(5000, "5.000 Pulsa"),
            Reward(10000, "10.000 Pulsa"),
            Reward(5000, "5.000 Pulsa"),
            Reward(10000, "10.000 Pulsa"),
            Reward(5000, "5.000 Pulsa"),
            Reward(10000, "10.000 Pulsa"),
            Reward(15000, "15.000 Pulsa")
        )
        rewardAdapter = RewardAdapter(rewards)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@RewardActivity)
            adapter = rewardAdapter
        }
    }

    private fun setupClaimPointsButton() {
        binding.claimPointsButton.setOnClickListener {
            // Implement claim points logic here
        }
    }
}