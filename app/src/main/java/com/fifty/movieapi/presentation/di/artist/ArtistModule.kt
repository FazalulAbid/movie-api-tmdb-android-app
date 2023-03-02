package com.fifty.movieapi.presentation.di.artist

import com.fifty.movieapi.domain.usecase.GetArtistsUseCase
import com.fifty.movieapi.domain.usecase.UpdateArtistsUseCase
import com.fifty.movieapi.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistsUseCase,
            updateArtistsUseCase
        )
    }
}