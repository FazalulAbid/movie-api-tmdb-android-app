package com.fifty.movieapi.presentation.di.artist

import com.fifty.movieapi.presentation.artist.ArtistActivity
import dagger.Subcomponent

@ArtistScope
@Subcomponent(
    modules = [
        ArtistModule::class
    ]
)
interface ArtistSubComponent {

    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): ArtistSubComponent
    }
}