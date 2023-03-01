package com.fifty.movieapi.data.repository.artist.datasource

import com.fifty.movieapi.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}