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


    fun setup() {
        nav_home = activity.findViewById(R.id.nav_home)
        nav_history = activity.findViewById(R.id.nav_history)
        nav_favorite = activity.findViewById(R.id.nav_favorite)
        nav_list = activity.findViewById(R.id.nav_list)

        icon_home = activity.findViewById(R.id.iv_home)
        icon_history = activity.findViewById(R.id.iv_history)
        icon_favorite = activity.findViewById(R.id.iv_favorite)
        icon_list = activity.findViewById(R.id.iv_list)

        highlight(current)

        nav_home.setOnClickListener { select("home") }
        nav_history.setOnClickListener { select("history") }
        nav_favorite.setOnClickListener { select("favorite") }
        nav_list.setOnClickListener { select("list") }
    }

    private fun select(target: String) {
        if (current == target) return
        current = target
        highlight(target)
        onNavigate(target)
    }

    private fun highlight(target: String) {

        val inactive = Color.parseColor("#8FA3B8")
        val active = Color.WHITE
        val activeBg = R.drawable.nav_active_bg

        resetAll(inactive)

        when (target) {
            "home" -> setActive(nav_home, icon_home, active, activeBg)
            "history" -> setActive(nav_history, icon_history, active, activeBg)
            "favorite" -> setActive(nav_favorite, icon_favorite, active, activeBg)
            "list" -> setActive(nav_list, icon_list, active, activeBg)
        }
    }

    private fun resetAll(color: Int) {
        icon_home.setColorFilter(color)
        icon_history.setColorFilter(color)
        icon_favorite.setColorFilter(color)
        icon_list.setColorFilter(color)

        nav_home.background = null
        nav_history.background = null
        nav_favorite.background = null
        nav_list.background = null
    }

    private fun setActive(container: LinearLayout, icon: ImageView, color: Int, bg: Int) {
        icon.setColorFilter(color)
        container.setBackgroundResource(bg)  // ⬅ highlight luas di container
    }
}
