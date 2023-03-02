package com.fifty.movieapi.presentation.di.core

import com.fifty.movieapi.data.api.TMDBService
import com.fifty.movieapi.data.repository.artist.datasource.ArtistRemoteDataSource
import com.fifty.movieapi.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import com.fifty.movieapi.data.repository.movie.datasource.MovieRemoteDataSource
import com.fifty.movieapi.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.fifty.movieapi.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.fifty.movieapi.data.repository.tvshow.datasourceimpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun providesTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Singleton
    @Provides
    fun providesArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(tmdbService, apiKey)
    }
}