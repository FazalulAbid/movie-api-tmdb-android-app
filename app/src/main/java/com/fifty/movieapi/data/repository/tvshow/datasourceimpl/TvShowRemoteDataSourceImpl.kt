package com.fifty.movieapi.data.repository.tvshow.datasourceimpl

import com.fifty.movieapi.data.api.TMDBService
import com.fifty.movieapi.data.model.tvshow.TvShowList
import com.fifty.movieapi.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : TvShowRemoteDataSource {

    override suspend fun getTvShows(): Response<TvShowList> =
        tmdbService.getPopularTvShows(apiKey)

}