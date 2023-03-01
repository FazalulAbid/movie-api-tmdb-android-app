package com.fifty.movieapi.data.repository.movie.datasource

import com.fifty.movieapi.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}