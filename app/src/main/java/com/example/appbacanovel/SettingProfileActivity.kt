package com.example.appbacanovel

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.button.MaterialButton

class SettingProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.setting_profile)

        // AMBIL VIEW
        val edtUsername = findViewById<TextInputEditText>(R.id.edtUsername)
        val edtUmur = findViewById<TextInputEditText>(R.id.edtUmur)
        val txtEmail = findViewById<TextInputEditText>(R.id.txtEmail)
        val btnSimpan = findViewById<MaterialButton>(R.id.btnSimpan)

        // AMBIL DATA DARI SHAREDPREF
        val pref = getSharedPreferences("userData", MODE_PRIVATE)
        val username = pref.getString("username", "")
        val umur = pref.getString("umur", "")
        val email = pref.getString("email", "")

        // TAMPILKAN DI FORM
        edtUsername.setText(username)
        edtUmur.setText(umur)
        txtEmail.setText(email)

        // SIMPAN PERUBAHAN KETIKA TOMBOL DIKLIK
        btnSimpan.setOnClickListener {
            val newUsername = edtUsername.text.toString()
            val newUmur = edtUmur.text.toString()

            if (newUsername.isEmpty() || newUmur.isEmpty()) {
                Toast.makeText(this, "Data tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // SIMPAN KE SHAREDPREF
            pref.edit()
                .putString("username", newUsername)
                .putString("umur", newUmur)
                .apply()

            Toast.makeText(this, "Perubahan berhasil disimpan!", Toast.LENGTH_SHORT).show()

            finish() // kembali ke FragmentProfile
        }
    }
}
