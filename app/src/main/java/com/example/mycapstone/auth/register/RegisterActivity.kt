package com.example.mycapstone.auth.register

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mycapstone.auth.login.LoginActivity
import com.example.mycapstone.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        binding.registerButton.setOnClickListener {
            val email = binding.gmailEditText.text.toString()
            val name = binding.usernameEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            registerUser(name, email, password)
        }
    }

    private fun registerUser(name: String, email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val userId = auth.currentUser?.uid ?: ""
                    saveUserToFirestore(userId, name, email)
                    val intent = Intent(this, LoginActivity::class.java)
                    Toast.makeText(this, "Register Success. Please check your email", Toast.LENGTH_SHORT).show()
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Register Failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun saveUserToFirestore(userId: String, name: String, email: String) {
        val userMap = hashMapOf(
            "name" to name,
            "email" to email,
            "userId" to userId
        )
        db.collection("users").document(userId).set(userMap)
            .addOnSuccessListener {
                Toast.makeText(this, "User registered successfully", Toast.LENGTH_LONG).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Failed to save user data: ${e.message}", Toast.LENGTH_LONG).show()
            }
    }
}
