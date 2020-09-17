package com.machnv.databinding.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private var _firstName: MutableLiveData<String> = MutableLiveData("John")
    private var _lastName: MutableLiveData<String> = MutableLiveData("Smith")
    private var _like: MutableLiveData<Int> = MutableLiveData(0)

    val firstName: LiveData<String> = _firstName
    val lastName: LiveData<String> = _lastName
    val like: LiveData<Int> = _like

    fun setFirstName(firstName: String) {
        _firstName.value = firstName
    }
    fun setLastName(lastName: String) {
        _lastName.value = lastName
    }
    fun setLikeName(like: Int) {
        _like.value = like
    }

    fun onLikeClick() {
        _like.value = _like.value?.plus(1)
        setFirstName("fucking John")
        setLastName("Smithy")
    }

}