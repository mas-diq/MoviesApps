package com.dicoding.moviesapps.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tvshows")
data class TvShowEntity(
    @PrimaryKey
    var tvShowId: String,
    var title: String,
    var description: String,
    var episode: String,
    var bookmarked: Boolean = false,
    var imagePath: String
)