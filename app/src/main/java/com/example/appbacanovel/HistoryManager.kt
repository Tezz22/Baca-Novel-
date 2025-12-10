package com.example.appbacanovel

import android.content.Context
import android.util.Log
import org.json.JSONArray
import org.json.JSONObject

object HistoryManager {
    private const val PREF_NAME = "history_pref"
    private const val KEY_HISTORY = "history_list"

    fun saveHistory(context: Context, book: Book) {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val oldArray = getHistoryArray(context)
        val newArray = JSONArray()

        val obj = JSONObject()
        obj.put("id", book.id)
        obj.put("lastRead", System.currentTimeMillis())
        newArray.put(obj)

        for (i in 0 until oldArray.length()) {
            val item = oldArray.getJSONObject(i)
            if (item.getInt("id") != book.id) {
                newArray.put(item)
            }
        }

        prefs.edit().putString(KEY_HISTORY, newArray.toString()).apply()
    }

    fun getHistoryArray(context: Context): JSONArray {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return JSONArray(prefs.getString(KEY_HISTORY, "[]"))
    }

    fun getHistoryBooks(context: Context): MutableList<Book> {
        val arr = getHistoryArray(context)
        val result = mutableListOf<Book>()

        for (i in 0 until arr.length()) {
            val obj = arr.getJSONObject(i)
            val id = obj.getInt("id")
            val lastRead = obj.getLong("lastRead")

            val book = BookData.getBookList().find { it.id == id }
            if (book != null) {
                book.status = lastRead
                result.add(book)
            }
        }
        return result
    }

}

