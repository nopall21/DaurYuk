package com.example.mycapstone.history.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mycapstone.databinding.ItemHistoryBinding
import com.example.mycapstone.history.db.ClassificationResult
import java.io.File

class ClassificationAdapter(
    private val items: List<ClassificationResult>,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<ClassificationAdapter.ClassificationViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(result: ClassificationResult)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassificationViewHolder {
        val binding = ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ClassificationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ClassificationViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ClassificationViewHolder(private val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(result: ClassificationResult) {
            val imageFile = File(result.imageUri)
            binding.imageClassification.setImageURI(Uri.fromFile(imageFile))
            binding.classificationTextView.text = result.title
            binding.confidenceTextView.text = result.description

            binding.root.setOnClickListener {
                itemClickListener.onItemClick(result)
            }
        }
    }
}
