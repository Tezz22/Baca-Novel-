package com.example.appbacanovel

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.imageview.ShapeableImageView

class FragmentProfile : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // VIEW BARU
        val imgProfile = view.findViewById<ShapeableImageView>(R.id.imgProfileUser)
        val txtName = view.findViewById<TextView>(R.id.txtNameUser)
        val txtEmail = view.findViewById<TextView>(R.id.txtEmailUser)
        val btnSetting = view.findViewById<MaterialButton>(R.id.btn_setting_profile)
        val btnLogout = view.findViewById<MaterialButton>(R.id.btn_logout)

        // AMBIL DATA USER
        val pref = requireContext().getSharedPreferences("userData", android.content.Context.MODE_PRIVATE)
        val username = pref.getString("username", "Pengguna")
        val email = pref.getString("email", "email@contoh.com")
        val fotoUri = pref.getString("foto", null)

        // TAMPILKAN DATA KE VIEW
        txtName.text = username
        txtEmail.text = email

        if (fotoUri != null) {
            imgProfile.setImageURI(Uri.parse(fotoUri))
        }

        // KE HALAMAN SETTING PROFILE
        btnSetting.setOnClickListener {
            startActivity(Intent(requireContext(), SettingProfile::class.java))
        }

        // ➤ TOMBOL LOGOUT + DIALOG
        btnLogout.setOnClickListener {

            AlertDialog.Builder(requireContext())
                .setTitle("Logout")
                .setMessage("Apakah kamu yakin ingin keluar?")
                .setPositiveButton("Ya") { _, _ ->

                    // Hapus data SharedPreferences
                    pref.edit().clear().apply()

                    // Pindah ke LoginActivity
                    val intent = Intent(requireContext(), LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
                .setNegativeButton("Batal", null)
                .show()
        }

        return view
    }
}
