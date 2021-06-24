package com.dicoding.moviesapps.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MovieEntity(
    @PrimaryKey
    var moviesId: String,

    var title: String,
    var description: String,
    var duration: String,
    var bookmarked: Boolean = false,
    var imagePath: String
)