package com.example.themoviedb.views

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themoviedb.data.Detail
import com.example.themoviedb.data.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(val repository: MovieRepository): ViewModel() {

    val detail = MutableLiveData<Detail?>()
    val loading = MutableLiveData<Boolean>(false)
    fun getDetail(id: Int) {
        loading.value = true
        viewModelScope.launch {
            val response = repository.getDetail(id)
            detail.value = response
            loading.value = false
        }
    }
}