package com.fifty.movieapi.presentation.di.core

import com.fifty.movieapi.data.repository.artist.datasource.ArtistCacheDataSource
import com.fifty.movieapi.data.repository.artist.datasourceimpl.ArtistCacheDataSourceImpl
import com.fifty.movieapi.data.repository.movie.datasource.MovieCacheDataSource
import com.fifty.movieapi.data.repository.movie.datasourceimpl.MovieCacheDataSourceImpl
import com.fifty.movieapi.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.fifty.movieapi.data.repository.tvshow.datasourceimpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}