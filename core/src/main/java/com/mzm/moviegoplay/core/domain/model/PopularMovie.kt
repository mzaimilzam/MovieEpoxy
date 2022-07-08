package com.mzm.moviegoplay.core.domain.model

/**
 * Created by Muhammad Zaim Milzam on 09/06/2022.
 * linkedin : Muhammad Zaim Milzam
 */
data class PopularMovie(
    val id: Int,
    val posterPath: String,
    val posterPathUrl: String,
    val title: String,
    val overview: String,
    val releaseDate: String
)
