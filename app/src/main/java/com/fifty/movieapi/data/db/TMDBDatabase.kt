package com.fifty.movieapi.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fifty.movieapi.data.model.artist.Artist
import com.fifty.movieapi.data.model.movie.Movie
import com.fifty.movieapi.data.model.tvshow.TvShow

@Database(
    entities = [Movie::class, Artist::class, TvShow::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TvShowDao
    abstract fun artistDao(): ArtistDao
}