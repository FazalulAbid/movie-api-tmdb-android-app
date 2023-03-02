package com.fifty.movieapi.presentation

import android.app.Application
import com.fifty.movieapi.BuildConfig
import com.fifty.movieapi.presentation.di.Injector
import com.fifty.movieapi.presentation.di.artist.ArtistSubComponent
import com.fifty.movieapi.presentation.di.core.*
import com.fifty.movieapi.presentation.di.movie.MovieSubComponent
import com.fifty.movieapi.presentation.di.tvshow.TvShowSubComponent

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}