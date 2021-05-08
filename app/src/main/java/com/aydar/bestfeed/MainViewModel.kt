package com.aydar.bestfeed

import androidx.lifecycle.ViewModel
import com.aydar.data.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val preferences: Preferences) :
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