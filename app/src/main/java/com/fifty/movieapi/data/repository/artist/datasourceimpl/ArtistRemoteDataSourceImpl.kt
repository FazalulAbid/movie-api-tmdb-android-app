package com.fifty.movieapi.data.repository.artist.datasourceimpl

import com.fifty.movieapi.data.api.TMDBService
import com.fifty.movieapi.data.model.artist.ArtistList
import com.fifty.movieapi.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : ArtistRemoteDataSource {

    override suspend fun getArtists(): Response<ArtistList> =
        tmdbService.getPopularArtist(apiKey)

}