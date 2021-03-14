package com.aydar.data

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class Preferences @Inject constructor(@ApplicationContext context: Context) {

    private val sharedPref = context.getSharedPreferences(
        SHARED_PREFS_NAME,
        Context.MODE_PRIVATE
    )

    var vkToken: String?
        get() = sharedPref.getString(VK_TOKEN, null)
        set(value) = sharedPref.edit().putString(VK_TOKEN, value).apply()

    companion object {
        private const val SHARED_PREFS_NAME = "com.aydar.bestfeed"

        private const val VK_TOKEN = "vkToken"
    }
}