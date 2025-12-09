package com.example.appbacanovel

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class HomeActivity : AppCompatActivity() {

    private lateinit var bottom_nav: BottomNav
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val emailUser = intent.getStringExtra("email_user")

//        loadFragment(FragmentHome())
//
//        findViewById<View>(R.id.nav_profile).setOnClickListener {
//            val fragment = FragmentProfile()
//
//            val bundle = Bundle()
//            bundle.putString("email_user", emailUser)
//            fragment.arguments = bundle
//
//            loadFragment(fragment)
//        }
//
//        findViewById<View>(R.id.nav_home).setOnClickListener {
//            loadFragment(FragmentHome())
//        }
//        findViewById<View>(R.id.nav_history).setOnClickListener {
//            loadFragment(FragmentHistory())
//        }
//        findViewById<View>(R.id.nav_favorite).setOnClickListener {
//            loadFragment(FragmentFavorite())
//        }
//        findViewById<View>(R.id.nav_list).setOnClickListener {
//            loadFragment(FragmentList())
//        }
//        findViewById<View>(R.id.nav_search).setOnClickListener {
//            loadFragment(FragmentSearch())
//        }

        bottom_nav = BottomNav(
            activity = this,
            current = "home",
        ){ target -> navigate(target)}
        bottom_nav.setup()
        navigate("home")
    }

    private fun navigate(target: String) {
        val fragment = when (target) {
            "home" -> FragmentHome()
            "search" -> FragmentSearch()
            "history" -> FragmentHistory()
            "profile" -> FragmentProfile()
            "favorite" -> FragmentFavorite()
            "list" -> FragmentList()
            else -> FragmentHome()

        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}
