package com.fifty.movieapi.domain.repository

import com.fifty.movieapi.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}