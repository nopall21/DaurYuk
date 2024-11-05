package com.example.mycapstone.auth.login

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.mycapstone.ui.MainActivity
import com.example.mycapstone.R
import com.example.mycapstone.auth.UserPreference
import com.example.mycapstone.auth.dataStore
import com.example.mycapstone.databinding.ActivityLoginBinding
import com.example.mycapstone.auth.register.RegisterActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var userPref: UserPreference
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()
        userPref = UserPreference.getInstance(applicationContext.dataStore)

        checkLoginStatus()

        val text = "Belum punya akun? Daftar"
        val spannableString = SpannableString(text)

        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
                startActivity(intent)
            }
        }

        val start = text.indexOf("Daftar")
        val end = start + "Daftar".length

        spannableString.setSpan(clickableSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(UnderlineSpan(), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        val linkColor = resources.getColor(R.color.selected_bottom_nav_color, null)
        spannableString.setSpan(
            ForegroundColorSpan(linkColor),
            start,
            end,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        binding.registerDesc.text = spannableString
        binding.registerDesc.movementMethod = LinkMovementMethod.getInstance()

        binding.loginButton.setOnClickListener {
            val email = binding.gmailEditText.text.toString().trim()
            val password = binding.passwordEditText.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                loginUser(email, password)
            } else {
                Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun checkLoginStatus() {
        lifecycleScope.launch {
            if (userPref.isLoggedIn.first()) {
                navigateToMainActivity()
            }
        }
    }

    private fun loginUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    val userId = user?.uid

                    if (userId != null) {
                        db.collection("users").document(userId).get()
                            .addOnSuccessListener { document ->
                                if (document != null) {
                                    val username = document.getString("name") ?: "User"
                                    lifecycleScope.launch {
                                        saveLoginState(username)
                                        navigateToMainActivity()
                                    }
                                }
                            }
                            .addOnFailureListener { e ->
                                Toast.makeText(this, "Failed to fetch user data: ${e.message}", Toast.LENGTH_LONG).show()
                            }
                    } else {
                        Toast.makeText(this, "Login failed: User ID not found", Toast.LENGTH_LONG).show()
                    }
                } else {
                    Toast.makeText(
                        this,
                        "Login failed: ${task.exception?.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
    }

    private suspend fun saveLoginState(username: String) {
        userPref.saveLoginState(true, username)
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
