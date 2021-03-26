package com.aydar.featuremain

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aydar.data.model.groupWallRemote.Item
import com.aydar.domain.GetBestFeedInteractor
import kotlinx.coroutines.launch

class HomeViewModel
@ViewModelInject constructor(private val getBestFeedInteractor: GetBestFeedInteractor) :
    ViewModel() {

    val postsLiveData = MutableLiveData<List<Item>>()

    fun getFeed() {
        viewModelScope.launch {
            val posts = getBestFeedInteractor(listOf("mudakoff"))
            postsLiveData.postValue(posts)
        }
    }
}