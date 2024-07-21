package com.example.mytvappcompose.interfaces

import androidx.lifecycle.LiveData
import com.example.mytvappcompose.model.MovieResult

interface MovieRepository {
    val movies: LiveData<List<List<MovieResult>>>

    suspend fun fetchAllMovies()


}