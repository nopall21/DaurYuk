package com.example.mycapstone.reward.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mycapstone.R

class RewardAdapter(private val rewards: List<com.example.mycapstone.reward.Reward>) :
    RecyclerView.Adapter<RewardAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.nameTextView)
        val pointsTextView: TextView = view.findViewById(R.id.pointsTextView)
        val claimButton: Button = view.findViewById(R.id.claimButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_reward, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val reward = rewards[position]
        holder.nameTextView.text = "${reward.points} Point"
        holder.pointsTextView.text = reward.description
        holder.claimButton.setOnClickListener {
            // Implement claim logic here
        }
    }

    override fun getItemCount() = rewards.size
}
