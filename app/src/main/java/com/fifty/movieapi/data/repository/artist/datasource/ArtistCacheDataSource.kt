package com.fifty.movieapi.data.repository.artist.datasource

import com.fifty.movieapi.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache(): List<Artist>
    suspend fun saveArtistToCache(artists: List<Artist>)
}