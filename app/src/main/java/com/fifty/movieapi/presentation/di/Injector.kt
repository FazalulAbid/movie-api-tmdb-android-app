package com.fifty.movieapi.presentation.di

import com.fifty.movieapi.presentation.di.artist.ArtistSubComponent
import com.fifty.movieapi.presentation.di.movie.MovieSubComponent
import com.fifty.movieapi.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}