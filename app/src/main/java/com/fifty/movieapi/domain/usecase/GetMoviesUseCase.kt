package com.fifty.movieapi.domain.usecase

import com.fifty.movieapi.data.model.movie.Movie
import com.fifty.movieapi.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
}