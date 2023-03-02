package com.fifty.movieapi.presentation.di.tvshow

import com.fifty.movieapi.presentation.tvshow.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(
    modules = [
        TvShowModule::class
    ]
)
interface TvShowSubComponent {

    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowSubComponent
    }
}