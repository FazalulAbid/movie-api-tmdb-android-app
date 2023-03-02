package com.fifty.movieapi.presentation.di.tvshow

import com.fifty.movieapi.domain.usecase.GetTvShowsUseCase
import com.fifty.movieapi.domain.usecase.UpdateTvShowsUseCase
import com.fifty.movieapi.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(
            getTvShowsUseCase,
            updateTvShowsUseCase
        )
    }
}