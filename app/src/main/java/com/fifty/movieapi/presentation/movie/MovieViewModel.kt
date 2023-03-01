package com.fifty.movieapi.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.fifty.movieapi.domain.usecase.GetMoviesUseCase
import com.fifty.movieapi.domain.usecase.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovieList() = liveData {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }

}