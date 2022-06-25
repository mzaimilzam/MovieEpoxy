package com.mzm.moviegoplay.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mzm.moviegoplay.core.data.source.local.entity.*
import com.mzm.moviegoplay.core.data.source.local.room.dao.FilmDao
import com.mzm.moviegoplay.core.data.source.local.room.dao.FilmRemoteKeyDao
import com.mzm.moviegoplay.core.util.Constants

/**
 * Created by Muhammad Zaim Milzam on 08/03/2022.
 * linkedin : Muhammad Zaim Milzam
 */

@Database(
    entities = [
        PopularMovieEntity::class,
        PopularMovieRemoteKey::class,
        PopularTVEntity::class,
        TrendingMovieEntity::class,
        TrendingTVEntity::class
    ],
    version = Constants.DATABASE_VERSION,
    exportSchema = false
)
abstract class Database : RoomDatabase() {

    abstract fun filmDao(): FilmDao
    abstract fun filmRemoteKeyDao(): FilmRemoteKeyDao
}