package com.example.themoviedb.views

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themoviedb.data.Movie
import com.example.themoviedb.data.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(val repository: MovieRepository) : ViewModel() {

    val detail = MutableLiveData<Movie?>()
    val fav = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>(false)

    fun getDetail(id: Int) {
        loading.value = true
        viewModelScope.launch {
            val movie = repository.getDetail(id)
            detail.value = movie
            //fav.value=movie.fav
            loading.value = false
        }
    }

    fun movieFavEvent(id: Int) {
        viewModelScope.launch {
            val movieDb = repository.getDetailDb(id).firstOrNull()
            detail.value?.let {
                if (movieDb == null) {
                    it.fav = true
                    fav.value = true
                    repository.insertMovieFav(it)
                    repository.insertGenreEntity(it)
                } else {
                    it.fav = false
                    fav.value = false
                    repository.deleteMovieFav(id)
                }
            }
        }
    }

}