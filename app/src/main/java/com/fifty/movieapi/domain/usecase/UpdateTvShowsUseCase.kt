package com.fifty.movieapi.domain.usecase

import com.fifty.movieapi.data.model.tvshow.TvShow
import com.fifty.movieapi.domain.repository.TvShowRepository

class UpdateTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute(): List<TvShow>? = tvShowRepository.updateTvShows()
}