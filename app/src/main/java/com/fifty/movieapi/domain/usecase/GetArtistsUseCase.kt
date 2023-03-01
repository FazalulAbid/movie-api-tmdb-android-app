package com.fifty.movieapi.domain.usecase

import com.fifty.movieapi.data.model.artist.Artist
import com.fifty.movieapi.domain.repository.ArtistRepository

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.getArtists()
}