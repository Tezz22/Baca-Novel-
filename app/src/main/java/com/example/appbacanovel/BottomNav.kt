package com.example.appbacanovel

import android.app.Activity
import android.graphics.Color
import android.widget.ImageView
import android.widget.LinearLayout

class BottomNav(
    private val activity: Activity,
    private var current: String,
    private val onNavigate: (String) -> Unit
) {

    private lateinit var nav_home: LinearLayout
    private lateinit var nav_history: LinearLayout
    private lateinit var nav_favorite: LinearLayout
    private lateinit var nav_list: LinearLayout



    private lateinit var icon_home: ImageView
    private lateinit var icon_history: ImageView
    private lateinit var icon_favorite: ImageView
    private lateinit var icon_list: ImageView
    private lateinit var nav_search: ImageView
    private lateinit var nav_profile: ImageView


    fun setup() {
        nav_home = activity.findViewById(R.id.nav_home)
        nav_history = activity.findViewById(R.id.nav_history)
        nav_favorite = activity.findViewById(R.id.nav_favorite)
        nav_list = activity.findViewById(R.id.nav_list)

        icon_home = activity.findViewById(R.id.iv_home)
        icon_history = activity.findViewById(R.id.iv_history)
        icon_favorite = activity.findViewById(R.id.iv_favorite)
        icon_list = activity.findViewById(R.id.iv_list)
        nav_search = activity.findViewById(R.id.nav_search)
        nav_profile = activity.findViewById(R.id.nav_profile)



        highlight(current)

        nav_home.setOnClickListener { select("home") }
        nav_history.setOnClickListener { select("history") }
        nav_favorite.setOnClickListener { select("favorite") }
        nav_list.setOnClickListener { select("list") }
        nav_search.setOnClickListener { select("search") }
        nav_profile.setOnClickListener { select("profile") }
    }

    private fun select(target: String) {
        if (current == target) return
        current = target
        highlight(target)
        onNavigate(target)
    }

    private fun highlight(target: String) {

        val inactive = Color.parseColor("#8FA3B8")
        val active = Color.parseColor("#000000")
        val activeBg = R.drawable.set_active_nav

        resetAll(inactive)

        when (target) {
            "home" -> setActive(icon_home, active, activeBg)
            "history" -> setActive(icon_history, active, activeBg)
            "favorite" -> setActive(icon_favorite, active, activeBg)
            "list" -> setActive(icon_list, active, activeBg)

        }
    }

    private fun resetAll(color: Int) {
        icon_home.setColorFilter(color)
        icon_history.setColorFilter(color)
        icon_favorite.setColorFilter(color)
        icon_list.setColorFilter(color)

        icon_home.background = null
        icon_history.background = null
        icon_favorite.background = null
        icon_list.background = null
    }

    private fun setActive(icon: ImageView, color: Int, bg: Int) {
        icon.setColorFilter(color)
        icon.setBackgroundResource(bg)
    }
}