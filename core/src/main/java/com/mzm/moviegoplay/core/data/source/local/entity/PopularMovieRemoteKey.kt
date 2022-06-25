package com.mzm.moviegoplay.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Muhammad Zaim Milzam on 15/03/2022.
 * linkedin : Muhammad Zaim Milzam
 */

@Entity(tableName = "popular_movie_remote_key")
data class  PopularMovieRemoteKey(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    val prevPage: Int,
    val nextPage: Int
)
