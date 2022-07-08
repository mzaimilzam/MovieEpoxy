package com.mzm.moviegoplay.core.domain.model

data class Film(
    val id: Int,
    val posterPath: String,
    val posterPathUrl: String,
    val title: String,
    val overview: String,
    val releaseDate: String,
    val mediaType: String
)
