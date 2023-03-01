package com.fifty.movieapi.data.repository.artist.datasource

import com.fifty.movieapi.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistFromDB(): List<Artist>
    suspend fun saveArtistToDB(artists: List<Artist>)
    suspend fun clearAll()
}