package com.aydar.featuremain

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aydar.domain.GetGroupPostsInteractor
import kotlinx.coroutines.launch

class HomeViewModel
@ViewModelInject constructor(private val getGroupPostsInteractor: GetGroupPostsInteractor) :
    ViewModel() {


    fun getFeed() {
        viewModelScope.launch {
            val posts = getGroupPostsInteractor.getGroupPosts()
            println()
        }
    }
}