package com.aydar.bestfeed

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.aydar.data.Preferences

class MainViewModel @ViewModelInject constructor(private val preferences: Preferences) :
    ViewModel() {

    val eventAuthorize = SingleLiveEvent<Unit>()

    fun checkAuthorization() {
        if (preferences.vkToken.isNullOrBlank()) {
            eventAuthorize.postValue(Unit)
        }
    }

    fun onAuthorizePassed(token: String) {
        preferences.vkToken = token
    }
}