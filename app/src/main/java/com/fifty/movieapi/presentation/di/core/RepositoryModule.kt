package com.fifty.movieapi.presentation.di.core

import com.fifty.movieapi.data.repository.artist.ArtistRepositoryImpl
import com.fifty.movieapi.data.repository.artist.datasource.ArtistLocalDataSource
import com.fifty.movieapi.data.repository.artist.datasource.ArtistRemoteDataSource
import com.fifty.movieapi.data.repository.movie.MovieRepositoryImpl
import com.fifty.movieapi.data.repository.movie.datasource.MovieCacheDataSource
import com.fifty.movieapi.data.repository.movie.datasource.MovieLocalDataSource
import com.fifty.movieapi.data.repository.movie.datasource.MovieRemoteDataSource
import com.fifty.movieapi.data.repository.tvshow.TvShowRepositoryImpl
import com.fifty.movieapi.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.fifty.movieapi.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.fifty.movieapi.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.fifty.movieapi.domain.repository.ArtistRepository
import com.fifty.movieapi.domain.repository.MovieRepository
import com.fifty.movieapi.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import com.fifty.movieapi.data.repository.artist.datasource.ArtistCacheDataSource as ArtistCacheDataSource1

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providesMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun providesTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun providesArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource1
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }
}