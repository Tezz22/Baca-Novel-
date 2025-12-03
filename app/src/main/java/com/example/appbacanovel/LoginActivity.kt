package com.example.appbacanovel

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        // ===========================================================
        // AUTO LOGIN CHECK (LETakkan DI SINI)
        // ===========================================================
        val pref = getSharedPreferences("userData", MODE_PRIVATE)

        if (pref.getBoolean("logged_in", false)) {
            startActivity(Intent(this, HomeActivity::class.java))
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            finish()
            return
        }

        // ===========================================================
        // SYSTEM BAR HANDLER (biarkan bawaan)
        // ===========================================================
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // ===========================================================
        // ANIMASI LOGIN PAGE
        // ===========================================================
        val fade = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val slideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up)

        val title = findViewById<TextView?>(R.id.tv_title)
        val cardLogin = findViewById<CardView?>(R.id.card_login)
        val tvSocial = findViewById<TextView?>(R.id.tv_social)
        val tvRegister = findViewById<TextView?>(R.id.tv_register_link)

        title?.startAnimation(fade)
        cardLogin?.startAnimation(slideUp)
        tvSocial?.startAnimation(fade.apply { startOffset = 300 })
        tvRegister?.startAnimation(fade.apply { startOffset = 500 })


        // ===========================================================
        // LOGIC LOGIN
        // ===========================================================
        val etEmail = findViewById<EditText>(R.id.et_email)
        val etPassword = findViewById<EditText>(R.id.et_password)
        val btnLogin = findViewById<Button>(R.id.btn_login)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Email & password wajib diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // VALIDASI EMAIL FORMAT
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Format email tidak valid!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // SIMPAN STATUS LOGIN + EMAIL
            pref.edit().apply {
                putBoolean("logged_in", true)
                putString("email", email)
                apply()
            }

            // MASUK HOME
            startActivity(Intent(this, HomeActivity::class.java))
            overridePendingTransition(R.anim.slide_up, R.anim.fade_out)
            finish()
        }

        // ===========================================================
        // PINDAH KE REGISTER ACTIVITY
        // ===========================================================
        tvRegister?.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            overridePendingTransition(R.anim.slide_up, R.anim.fade_out)
        }
    }
}
