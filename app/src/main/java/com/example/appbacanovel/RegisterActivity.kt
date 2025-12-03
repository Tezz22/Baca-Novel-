package com.example.appbacanovel

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // =============================
        // AMBIL XML VIEW
        // =============================
        val title = findViewById<TextView>(R.id.tv_title)
        val cardRegister = findViewById<CardView>(R.id.card_register)
        val tvLoginLink = findViewById<TextView>(R.id.tv_login_link)

        val etUsername = findViewById<EditText>(R.id.et_username)
        val etEmail = findViewById<EditText>(R.id.et_email)
        val etPassword = findViewById<EditText>(R.id.et_password)
        val etConfirmPassword = findViewById<EditText>(R.id.et_confirm_password)
        val etAge = findViewById<EditText>(R.id.et_age)

        val btnRegister = findViewById<Button>(R.id.btn_register)
        val loading = findViewById<ProgressBar>(R.id.progress_register)


        // =============================
        // ANIMASI PREMIUM
        // =============================
        val fade = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val slideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up)

        title.startAnimation(fade)
        cardRegister.startAnimation(slideUp)
        tvLoginLink.startAnimation(fade.apply { startOffset = 700 })


        // =============================
        // TOMBOL REGISTER
        // =============================
        btnRegister.setOnClickListener {

            val username = etUsername.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val confirmPassword = etConfirmPassword.text.toString().trim()
            val ageStr = etAge.text.toString().trim()

            // VALIDASI KOSONG
            if (username.isEmpty() || email.isEmpty() || password.isEmpty() ||
                confirmPassword.isEmpty() || ageStr.isEmpty()) {
                Toast.makeText(this, "Semua field wajib diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // VALIDASI FORMAT EMAIL
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Format email tidak valid!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // VALIDASI PASSWORD MATCH
            if (password != confirmPassword) {
                Toast.makeText(this, "Password tidak cocok!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // VALIDASI UMUR
            val age = ageStr.toIntOrNull()
            if (age == null || age < 13) {
                Toast.makeText(this, "Umur minimal 13 tahun!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // TAMPILKAN LOADING
            btnRegister.visibility = View.INVISIBLE
            loading.visibility = View.VISIBLE

            // SIMPAN USER KE SharedPreferences
            val pref = getSharedPreferences("userData", MODE_PRIVATE)
            pref.edit().apply {
                putString("username", username)
                putString("email", email)
                putString("umur", ageStr)
                putBoolean("logged_in", true) // AUTO-LOGIN
                apply()
            }

            // DELAY DIKIT BIAR LOADING KERASA
            loading.postDelayed({
                Toast.makeText(this, "Register berhasil!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, HomeActivity::class.java))
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                finish()
            }, 1200)
        }

        // =============================
        // KEMBALI LOGIN
        // =============================
        tvLoginLink.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            overridePendingTransition(R.anim.slide_up, R.anim.fade_out)
            finish()
        }
    }
}
