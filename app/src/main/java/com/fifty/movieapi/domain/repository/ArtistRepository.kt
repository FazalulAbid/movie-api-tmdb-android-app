package com.fifty.movieapi.domain.repository

import com.fifty.movieapi.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?
}