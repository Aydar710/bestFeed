package com.aydar.featuremain

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.aydar.domain.GetGroupPostsInteractor

class HomeViewModel
@ViewModelInject constructor(private val getGroupPostsInteractor: GetGroupPostsInteractor) :
    ViewModel() {

}