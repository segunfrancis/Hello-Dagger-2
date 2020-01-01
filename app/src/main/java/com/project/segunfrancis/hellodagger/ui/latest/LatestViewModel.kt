package com.project.segunfrancis.hellodagger.ui.latest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LatestViewModel : ViewModel(){
    private val _text = MutableLiveData<String>().apply {
        value = "Latest"
    }
    val text: LiveData<String> = _text
}