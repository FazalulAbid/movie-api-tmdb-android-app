package com.fifty.movieapi.data.repository.movie.datasource

import com.fifty.movieapi.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}