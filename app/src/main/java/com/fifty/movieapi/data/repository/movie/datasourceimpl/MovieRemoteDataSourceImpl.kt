package com.fifty.movieapi.data.repository.movie.datasourceimpl

import com.fifty.movieapi.data.api.TMDBService
import com.fifty.movieapi.data.model.movie.MovieList
import com.fifty.movieapi.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : MovieRemoteDataSource {

    override suspend fun getMovies(): Response<MovieList> =
        tmdbService.getPopularMovies(apiKey)

}