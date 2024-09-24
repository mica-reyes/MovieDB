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
    val upcomingList= MutableLiveData<MovieList?>()
    val topRatedList= MutableLiveData<MovieList?>()

    init {
        getMovieList()
        getUpcomingList()
        getTopRatedList()
    }

    fun getMovieList() {
        loading.value = true
        viewModelScope.launch {
            val response = repository.getMovieList()
            movieList.value = response
            loading.value = false
        }
    }

    fun getUpcomingList() {
        viewModelScope.launch {
            val response = repository.getUpcomingList()
            upcomingList.value= response
        }
    }

    fun getTopRatedList() {
        viewModelScope.launch {
            val response = repository.getTopRatedList()
            topRatedList.value= response
        }
    }
}