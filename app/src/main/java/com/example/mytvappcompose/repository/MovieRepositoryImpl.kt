package com.example.mytvappcompose.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mytvappcompose.model.MovieResult
import com.example.mytvappcompose.interfaces.MovieApiService
import com.example.mytvappcompose.interfaces.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton


//@Singleton
class MovieRepositoryImpl @Inject constructor(private val apiService: MovieApiService) : MovieRepository {

    private val _movies = MutableLiveData<List<List<MovieResult>>>()
    override val movies: LiveData<List<List<MovieResult>>> = _movies

    override suspend fun fetchAllMovies() {
        withContext(Dispatchers.IO) {
            val popularMovies = apiService.getPopularMovies().results
            val topRatedMovies = apiService.getTopRatedMovies().results
            val trendingMovies = apiService.getTrendingMovies().results
            val nowPlayingMovies = apiService.getNowPlayingMovies().results
            val upComingMovies = apiService.getUpcomingMovies().results

            _movies.postValue(
                listOf(
                    popularMovies,
                    topRatedMovies,
                    trendingMovies,
                    nowPlayingMovies,
                    upComingMovies
                )
            )
        }
    }
}