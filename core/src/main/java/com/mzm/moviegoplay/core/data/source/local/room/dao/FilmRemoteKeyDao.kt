package com.mzm.moviegoplay.core.data.source.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mzm.moviegoplay.core.data.source.local.entity.PopularMovieRemoteKey

/**
 * Created by Muhammad Zaim Milzam on 15/03/2022.
 * linkedin : Muhammad Zaim Milzam
 */

@Dao
interface FilmRemoteKeyDao {

    @Query("SELECT * FROM popular_movie_remote_key WHERE id = :id")
    suspend fun getRemoteKey(id: Int): PopularMovieRemoteKey?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(popularRemoteKeys: List<PopularMovieRemoteKey>)

    @Query("DELETE FROM popular_movie_remote_key")
    suspend fun deleteAllRemoteKeys()
}