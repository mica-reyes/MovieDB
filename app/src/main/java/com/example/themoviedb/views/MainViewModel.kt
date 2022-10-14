package com.example.themoviedb.views

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themoviedb.data.Detail
import com.example.themoviedb.data.MovieList
import com.example.themoviedb.data.MovieRepository
import kotlinx.coroutines.launch

class MainViewModel(val repository: MovieRepository) : ViewModel() {

    val loading = MutableLiveData<Boolean>(false)
    val movieList = MutableLiveData<MovieList?>()

    fun getMovieList() {
        loading.value = true
        viewModelScope.launch {
            val response = repository.getMovieList()
            movieList.value = response
            loading.value = false
        }
    }

    val detail = MutableLiveData<Detail?>()
    fun getDetail(id: Int) {
        loading.value = true
        viewModelScope.launch {
            val response = repository.getDetail(id)
            detail.value = response
            loading.value = false
        }
    }

}