package com.example.themoviedb.views

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.themoviedb.data.MovieRemoteDataSource
import com.example.themoviedb.data.MovieRepository

class MainViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val remoteDataSource= MovieRemoteDataSource()
        val repository= MovieRepository(remoteDataSource)
        val viewModel= MainViewModel(repository)
        return viewModel as T
    }
}