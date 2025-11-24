package com.example.appbacanovel

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        loadFragment(FragmentHome())

        findViewById<View>(R.id.nav_home).setOnClickListener {
            loadFragment(FragmentHome())
        }

        findViewById<View>(R.id.nav_history).setOnClickListener {
            loadFragment(FragmentHistory())
        }

        findViewById<View>(R.id.nav_favorite).setOnClickListener {
            loadFragment(FragmentFavorite())
        }

        findViewById<View>(R.id.nav_list).setOnClickListener {
            loadFragment(FragmentList())
        }

        findViewById<View>(R.id.nav_profile).setOnClickListener {
            loadFragment(FragmentProfile())
        }

        findViewById<View>(R.id.nav_search).setOnClickListener {
            loadFragment(FragmentSearch())
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()

    }
}