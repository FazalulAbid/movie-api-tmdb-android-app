package com.fifty.movieapi.presentation.di.core

import android.content.Context
import com.fifty.movieapi.presentation.di.artist.ArtistSubComponent
import com.fifty.movieapi.presentation.di.movie.MovieSubComponent
import com.fifty.movieapi.presentation.di.tvshow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    subcomponents = [
        MovieSubComponent::class,
        ArtistSubComponent::class,
        TvShowSubComponent::class
    ]
)
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun providesApplicationContext(): Context {
        return context.applicationContext
    }
}