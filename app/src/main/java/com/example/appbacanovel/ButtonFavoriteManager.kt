package com.example.appbacanovel

import android.content.Context

object ButtonFavoriteManager {

    private const val PREF_NAME = "MyPrefs"
    private const val KEY_FAVORITE = "key_favorite"

    fun getFavorites(context: Context): MutableSet<String> {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return prefs.getStringSet(KEY_FAVORITE, mutableSetOf())!!.toMutableSet()
    }

    fun addFavorite(context: Context, bookId: Int) {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val set = getFavorites(context)
        set.add(bookId.toString())
        prefs.edit().putStringSet(KEY_FAVORITE, set).apply()
    }

    fun removeFavorite(context: Context, bookId: Int) {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val set = getFavorites(context)
        set.remove(bookId.toString())
        prefs.edit().putStringSet(KEY_FAVORITE, set).apply()
    }

    fun isFavorite(context: Context, bookId: Int): Boolean {
        return getFavorites(context).contains(bookId.toString())
    }
}
