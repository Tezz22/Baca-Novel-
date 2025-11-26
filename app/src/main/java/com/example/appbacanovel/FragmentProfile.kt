package com.example.appbacanovel

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentProfile : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // AMBIL EMAIL DARI HOMEACTIVITY
        val emailUser = arguments?.getString("email_user")

        // TOMBOL SETTING PROFILE
        val btnSetting = view.findViewById<Button>(R.id.btn_setting_profile)

        btnSetting.setOnClickListener {
            val intent = Intent(requireContext(), SettingProfileActivity::class.java)
            intent.putExtra("email_user", emailUser)
            startActivity(intent)
        }

        return view
    }
}
