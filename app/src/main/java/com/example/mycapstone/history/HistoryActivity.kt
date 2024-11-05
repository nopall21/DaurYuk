package com.example.mycapstone.history

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycapstone.camera.ResultActivity
import com.example.mycapstone.history.adapter.ClassificationAdapter
import com.example.mycapstone.databinding.ActivityHistoryBinding
import com.example.mycapstone.history.db.AppDatabase
import com.example.mycapstone.history.db.ClassificationResult
import kotlinx.coroutines.launch

class HistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadHistory()
    }

    private fun loadHistory() {
        lifecycleScope.launch {
            try {
                val historyList = AppDatabase.getDatabase(this@HistoryActivity).classificationDao().getAll()
                binding.recyclerViewHistory.layoutManager = LinearLayoutManager(this@HistoryActivity)
                binding.recyclerViewHistory.adapter = ClassificationAdapter(historyList, object : ClassificationAdapter.OnItemClickListener {
                    override fun onItemClick(result: ClassificationResult) {
                        openResultActivity(result)
                    }
                })
            } catch (e: Exception) {
                // Log error dan tampilkan pesan kepada pengguna
                Log.e("HistoryActivity", "Error loading history", e)
                Toast.makeText(this@HistoryActivity, "Error loading history", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun openResultActivity(result: ClassificationResult) {
        val intent = Intent(this, ResultActivity::class.java).apply {
            putExtra("imageUri", result.imageUri)
            putExtra("title", result.title)
//            putExtra("category", result.category)  // Assuming you want to pass category, otherwise remove this line
            putExtra("description", result.description)
            putExtra("tips", result.tips)
        }
        startActivity(intent)
    }
}
