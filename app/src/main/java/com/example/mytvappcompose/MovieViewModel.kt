package com.example.mytvappcompose

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytvappcompose.model.MovieResult
import com.example.mytvappcompose.interfaces.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel  @Inject constructor(private val repository: MovieRepository) : ViewModel() {

    val movies: LiveData<List<List<MovieResult>>> = repository.movies


    init {
        fetchAllMovies()
    }

    fun fetchAllMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.fetchAllMovies()
        }
    }

}