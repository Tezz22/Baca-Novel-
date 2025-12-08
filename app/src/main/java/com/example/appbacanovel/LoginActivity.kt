package com.example.appbacanovel

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class LoginActivity : AppCompatActivity() {

    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var firebaseAuth: FirebaseAuth

    private val RC_SIGN_IN = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        // ===========================================================
        // AUTO LOGIN CHECK
        // ===========================================================
        val pref = getSharedPreferences("userData", MODE_PRIVATE)

        if (pref.getBoolean("logged_in", false)) {
            startActivity(Intent(this, HomeActivity::class.java))
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            finish()
            return
        }

        // ===========================================================
        // SYSTEM BAR HANDLER
        // ===========================================================
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // ===========================================================
        // ANIMASI LOGIN
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
        // LOGIN MANUAL
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

            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Format email tidak valid!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // SIMPAN LOGIN
            pref.edit().apply {
                putBoolean("logged_in", true)
                putString("email", email)
                apply()
            }

            startActivity(Intent(this, HomeActivity::class.java))
            overridePendingTransition(R.anim.slide_up, R.anim.fade_out)
            finish()
        }


        // ===========================================================
        // PINDAH KE REGISTER
        // ===========================================================
        tvRegister?.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            overridePendingTransition(R.anim.slide_up, R.anim.fade_out)
        }



        // ===========================================================
        // GOOGLE LOGIN SETUP
        // ===========================================================
        firebaseAuth = FirebaseAuth.getInstance()

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        val btnGoogle = findViewById<ImageView>(R.id.btn_google)

        btnGoogle.setOnClickListener {
            val signInIntent = googleSignInClient.signInIntent
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }
    }


    // ===========================================================
    // RESULT GOOGLE SIGN IN
    // ===========================================================
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)

            try {
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: Exception) {
                Toast.makeText(this, "Google Sign-In gagal", Toast.LENGTH_SHORT).show()
            }
        }
    }


    // ===========================================================
    // FIREBASE LOGIN MENGGUNAKAN GOOGLE
    // ===========================================================
    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)

        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {

                    val pref = getSharedPreferences("userData", MODE_PRIVATE)
                    pref.edit().apply {
                        putBoolean("logged_in", true)
                        putString("email", firebaseAuth.currentUser?.email)
                        apply()
                    }

                    Toast.makeText(this, "Login Google berhasil!", Toast.LENGTH_SHORT).show()

                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "Firebase Auth gagal", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
