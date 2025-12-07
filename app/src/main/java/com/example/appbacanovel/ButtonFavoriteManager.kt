package com.example.appbacanovel

import android.content.Context

object ButtonFavoriteManager {
    private const val KEY_FAVORITE = "key_favorite"

    fun getFavorite(context: Context): MutableSet<String> {
        val prefs = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        return prefs.getStringSet(KEY_FAVORITE, mutableSetOf()) ?: mutableSetOf()
    }

    fun addFavorite(context: Context, bookId: Int) {
        val prefs = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val favoriteSet = getFavorite(context)

        if (favoriteSet.contains(bookId.toString())) {
            favoriteSet.remove(bookId.toString())
        } else {
            favoriteSet.add(bookId.toString())
        }
        prefs.edit().putStringSet(KEY_FAVORITE, favoriteSet).apply()

    }

    fun isFavorite(context: Context, bookId: Int): Boolean {
        return getFavorite(context).contains(bookId.toString())
    }

}