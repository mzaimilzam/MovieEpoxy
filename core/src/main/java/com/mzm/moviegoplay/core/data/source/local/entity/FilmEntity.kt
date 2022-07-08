package com.mzm.moviegoplay.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "film_entity")
data class FilmEntity(

    @ColumnInfo(name = "overview")
    val overview: String? = null,

    @ColumnInfo(name = "original_language")
    val originalLanguage: String? = null,

    @ColumnInfo(name = "original_title")
    val originalTitle: String? = null,

    @ColumnInfo(name = "video")
    val video: Boolean? = null,

    @ColumnInfo(name = "title")
    val title: String? = null,

//	@ColumnInfo(name = "overview")
//	val genreIds: List<Int?>? = null,

    @ColumnInfo(name = "poster_path")
    val posterPath: String? = null,

    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String? = null,

    @ColumnInfo(name = "media_type")
    val mediaType: String? = null,

    @ColumnInfo(name = "release_date")
    val releaseDate: String? = null,

    @ColumnInfo(name = "popularity")
    val popularity: Double? = null,

    @ColumnInfo(name = "vote_average")
    val voteAverage: Double? = null,

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "adult")
    val adult: Boolean? = null,

    @ColumnInfo(name = "voteCount")
    val voteCount: Int? = null
)

