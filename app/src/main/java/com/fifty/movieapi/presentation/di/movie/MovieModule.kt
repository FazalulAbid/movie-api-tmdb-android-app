package com.fifty.movieapi.presentation.di.movie

import com.fifty.movieapi.domain.usecase.GetMoviesUseCase
import com.fifty.movieapi.domain.usecase.UpdateMoviesUseCase
import com.fifty.movieapi.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUseCase
        )
    }
}