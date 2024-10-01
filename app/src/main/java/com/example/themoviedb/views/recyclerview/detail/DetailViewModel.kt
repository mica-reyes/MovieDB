package com.example.themoviedb.views.recyclerview.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themoviedb.data.Movie
import com.example.themoviedb.data.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(val repository: MovieRepository) : ViewModel() {

    val detail = MutableLiveData<Movie?>()
    val loading = MutableLiveData<Boolean>(false)

    fun getDetail(id: Int) {
        loading.value = true
        viewModelScope.launch {
            val movie = repository.getDetail(id)
            detail.value = movie
            loading.value = false
        }
    }

    fun favIsChecked() {
        viewModelScope.launch {
            detail.value?.let {
                repository.insertMovieFav(it)
                repository.insertGenreEntity(it)
            }
        }
    }

    fun favUnchecked(id: Int) {
        viewModelScope.launch {
            detail.value?.let {
                repository.deleteMovieFav(id)
            }
        }
    }
}