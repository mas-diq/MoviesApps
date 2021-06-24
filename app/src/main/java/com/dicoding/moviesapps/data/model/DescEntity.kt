package com.dicoding.moviesapps.data.model

data class DescEntity(
    var descId: String,
    var movieId: String,
    var title: String,
    var position: Int,
    var read: Boolean = false
) {
    var contentEntity: ContentEntity? = null
}