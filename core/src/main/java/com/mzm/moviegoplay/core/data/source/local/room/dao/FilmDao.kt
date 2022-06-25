package com.mzm.moviegoplay.core.data.source.local.room.dao

import androidx.room.*
import com.mzm.moviegoplay.core.data.source.local.entity.PopularMovieEntity
import com.mzm.moviegoplay.core.data.source.local.entity.PopularTVEntity
import com.mzm.moviegoplay.core.data.source.local.entity.TrendingMovieEntity
import com.mzm.moviegoplay.core.data.source.local.entity.TrendingTVEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by Muhammad Zaim Milzam on 15/03/2022.
 * linkedin : Muhammad Zaim Milzam
 */

@Dao
interface FilmDao {

    // popular movie
    @Query("SELECT * FROM popular_movie_entity ORDER BY id ASC ")
    fun getAllPopularMovie(): Flow<List<PopularMovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPopularMovie(popular: List<PopularMovieEntity>)

    @Query("DELETE FROM popular_movie_entity")
    suspend fun deleteAllPopularMovie()

    @Transaction
    suspend fun insertAndDeletePopularMovie(popularMovie: List<PopularMovieEntity>) {
        deleteAllPopularMovie()
        addPopularMovie(popularMovie)
    }

    //popular tv
    @Query("SELECT * FROM popular_tv_entity ORDER BY id ASC ")
    fun getAllPopularTv(): Flow<List<PopularTVEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPopularTV(popular: List<PopularTVEntity>)

    @Transaction
    suspend fun insertAndDeletePopularTV(popularTv: List<PopularTVEntity>) {
        deleteAllPopularTv()
        addPopularTV(popularTv)
    }

    @Query("DELETE FROM popular_tv_entity")
    suspend fun deleteAllPopularTv()

    // trending movie
    @Query("SELECT * FROM trending_movie_entity ORDER BY id ASC ")
    fun getTrendingMovie(): Flow<List<TrendingMovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTrendingMovie(popular: List<TrendingMovieEntity>)

    @Query("DELETE FROM trending_movie_entity")
    suspend fun deleteAllTrendingMovie()

    @Transaction
    suspend fun insertAndDeleteTrendingMovie(trendingMovie: List<TrendingMovieEntity>) {
        deleteAllTrendingMovie()
        addTrendingMovie(trendingMovie)
    }

    // trending tv
    @Query("SELECT * FROM trending_tv_entity ORDER BY id ASC ")
    fun getTrendingTv(): Flow<List<TrendingTVEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTrendingTv(popular: List<TrendingTVEntity>)

    @Query("DELETE FROM trending_tv_entity")
    suspend fun deleteAllTrendingTv()

    @Transaction
    suspend fun insertAndDeleteTrendingTV(trendingTv: List<TrendingTVEntity>) {
        deleteAllTrendingTv()
        addTrendingTv(trendingTv)
    }
}
