package com.example.mytvappcompose

import com.example.mytvappcompose.interfaces.MovieApiService
import com.example.mytvappcompose.interfaces.MovieRepository
import com.example.mytvappcompose.repository.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideMovieApiService(): MovieApiService {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(apiService: MovieApiService): MovieRepository {
        return MovieRepositoryImpl(apiService)
    }

}