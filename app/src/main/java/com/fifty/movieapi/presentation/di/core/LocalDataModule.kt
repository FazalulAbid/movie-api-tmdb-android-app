package com.fifty.movieapi.presentation.di.core

import com.fifty.movieapi.data.db.ArtistDao
import com.fifty.movieapi.data.db.MovieDao
import com.fifty.movieapi.data.db.TvShowDao
import com.fifty.movieapi.data.repository.artist.datasource.ArtistLocalDataSource
import com.fifty.movieapi.data.repository.artist.datasourceimpl.ArtistLocalDataSourceImpl
import com.fifty.movieapi.data.repository.movie.datasource.MovieLocalDataSource
import com.fifty.movieapi.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import com.fifty.movieapi.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.fifty.movieapi.data.repository.tvshow.datasourceimpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun providesMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun providesTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun providesArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }
}