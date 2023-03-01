package com.fifty.movieapi.data.repository.tvshow.datasource

import com.fifty.movieapi.data.model.tvshow.TvShow


interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDB(): List<TvShow>
    suspend fun saveTvShowsToDB(tvShows: List<TvShow>)
    suspend fun clearAll()
}