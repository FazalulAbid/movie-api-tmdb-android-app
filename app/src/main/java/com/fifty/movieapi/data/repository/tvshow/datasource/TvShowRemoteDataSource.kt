package com.fifty.movieapi.data.repository.tvshow.datasource

import com.fifty.movieapi.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}