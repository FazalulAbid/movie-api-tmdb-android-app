package com.fifty.movieapi.data.repository.artist

import android.util.Log
import com.fifty.movieapi.data.model.artist.Artist
import com.fifty.movieapi.data.repository.artist.datasource.ArtistCacheDataSource
import com.fifty.movieapi.data.repository.artist.datasource.ArtistLocalDataSource
import com.fifty.movieapi.data.repository.artist.datasource.ArtistRemoteDataSource
import com.fifty.movieapi.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {

    override suspend fun getArtists(): List<Artist>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newArtistList = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistToDB(newArtistList)
        artistCacheDataSource.saveArtistToCache(newArtistList)
        return newArtistList
    }

    private suspend fun getArtistsFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()

            if (body != null)
                artistList = body.artists

        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        return artistList
    }

    private suspend fun getArtistsFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            artistList = artistLocalDataSource.getArtistFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistToDB(artistList)
        }

        return artistList
    }

    private suspend fun getArtistFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            artistList = artistCacheDataSource.getArtistsFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }

        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArtistToCache(artistList)
        }

        return artistList
    }
}