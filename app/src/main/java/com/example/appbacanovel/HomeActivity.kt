package com.example.appbacanovel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var bottom_nav: BottomNav
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val emailUser = intent.getStringExtra("email_user")

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
