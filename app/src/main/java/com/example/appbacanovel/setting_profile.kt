//package com.example.appbacanovel
//
//import android.app.Activity
//import android.content.Intent
//import android.net.Uri
//import android.os.Bundle
//import android.widget.Toast
//import androidx.activity.result.contract.ActivityResultContracts
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.content.edit
//import androidx.core.net.toUri
//import com.example.appbacanovel.databinding.SettingProfileBinding
//
//class SettingProfile : AppCompatActivity() {
//
//    private lateinit var binding: SettingProfileBinding
//    private var imgUri: Uri? = null
//
//    // ============================
//    // LAUNCHER UNTUK PILIH FOTO
//    // ============================
//    private val pickImage = registerForActivityResult(
//        ActivityResultContracts.StartActivityForResult()
//    ) { result ->
//        if (result.resultCode == RESULT_OK) {
//            imgUri = result.data?.data
//            binding.imgProfile.setImageURI(imgUri)    // tampilkan foto baru
//        }
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = SettingProfileBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        // LOAD DATA USER (contoh pakai SharedPreferences)
//        loadUserData()
//
//        // EVENT GANTI FOTO
//        binding.btnGantiFoto.setOnClickListener {
//            openGallery()
//        }
//
//        // EVENT SIMPAN PERUBAHAN
//        binding.btnSimpan.setOnClickListener {
//            saveProfile()
//        }
//    }
//
//    // ============================
//    // BUKA GALLERY UNTUK GANTI FOTO
//    // ============================
//    private fun openGallery() {
//        val intent = Intent(Intent.ACTION_PICK)
//        intent.type = "image/*"
//        pickImage.launch(intent)
//    }
//
//    // ============================
//    // LOAD DATA (contoh dari SharedPreferences)
//    // ============================
//    private fun loadUserData() {
//        val pref = getSharedPreferences("userData", MODE_PRIVATE)
//
//        binding.edtUsername.setText(pref.getString("username", ""))
//        binding.txtEmail.setText(pref.getString("email", "email@contoh.com"))
//        binding.edtUmur.setText(pref.getString("umur", ""))
//
//        val imageUri = pref.getString("foto", null)
//        if (imageUri != null) {
//            binding.imgProfile.setImageURI(imageUri.toUri())
//        }
//    }
//
//    // ============================
//    // SIMPAN PERUBAHAN PROFIL
//    // ============================
//    private fun saveProfile() {
//        val username = binding.edtUsername.text.toString().trim()
//        val umur = binding.edtUmur.text.toString().trim()
//
//        if (username.isEmpty()) {
//            binding.edtUsername.error = "Username tidak boleh kosong"
//            return
//        }
//
//        if (umur.isEmpty()) {
//            binding.edtUmur.error = "Umur tidak boleh kosong"
//            return
//        }
//
//        // Simpan ke SharedPreferences (bisa diganti Firebase)
//        getSharedPreferences("userData", MODE_PRIVATE).edit {
//            putString("username", username)
//            putString("umur", umur)
//
//            if (imgUri != null) {
//                putString("foto", imgUri.toString())
//            }
//        }
//
//        Toast.makeText(this, "Perubahan disimpan!", Toast.LENGTH_SHORT).show()
//    }
//}
