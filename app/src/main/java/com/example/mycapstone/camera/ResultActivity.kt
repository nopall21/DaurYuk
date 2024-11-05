package com.example.mycapstone.camera

import android.net.Uri
import com.bumptech.glide.Glide

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.mycapstone.R
import com.example.mycapstone.databinding.ActivityResultBinding
import java.io.File

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val imageUriString = intent.getStringExtra("imageUri")
        val title = intent.getStringExtra("title")
        val category = intent.getStringExtra("category")
        val description = intent.getStringExtra("description")
        val tips = intent.getStringExtra("tips")

        Log.d("ResultActivity", "Received image URI: $imageUriString")

        if (imageUriString != null) {
            val file = File(imageUriString)
            if (file.exists()) {
                Log.d("ResultActivity", "File exists at path: ${file.absolutePath}")
                Glide.with(this)
                    .load(file)
                    .error(R.drawable.ic_place_holder) // Add a placeholder error image
                    .into(binding.resultImageView)
            } else {
                Log.e("ResultActivity", "File does not exist at path: ${file.absolutePath}")
                // Handle the case when the file doesn't exist
                binding.resultImageView.setImageResource(R.drawable.ic_place_holder)
            }
        } else {
            Log.e("ResultActivity", "No image URI received")
        }

        binding.resultTitleTextView.text = title
        binding.categoryTextView.text = category
        binding.descriptionTextView.text = description
        binding.tipsTextView.text = tips
    }
}
