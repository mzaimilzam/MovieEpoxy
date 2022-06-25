package com.mzm.moviegoplay.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Muhammad Zaim Milzam on 15/03/2022.
 * linkedin : Muhammad Zaim Milzam
 */
@Entity(tableName = "popular_tv_entity")
data class PopularTVEntity(

    @ColumnInfo(name = "overview")
    val overview: String,

    @ColumnInfo(name = "original_language")
    val originalLanguage: String,

    @ColumnInfo(name = "original_title")
    val originalTitle: String,

        //    @ColumnInfo(name = "video")
        //    val video: Boolean,

    @ColumnInfo(name = "title")
    val title: String,

//    @ColumnInfo(name = "genre_ids")
//    val genreIds: String,

    @ColumnInfo(name = "poster_path")
    val posterPath: String,

    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String,

    @ColumnInfo(name = "release_date")
    val releaseDate: String,

    @ColumnInfo(name = "popularity")
    val popularity: Double,

    @ColumnInfo(name = "vote_average")
    val voteAverage: Double,

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "vote_count")
    val voteCount: Int
)