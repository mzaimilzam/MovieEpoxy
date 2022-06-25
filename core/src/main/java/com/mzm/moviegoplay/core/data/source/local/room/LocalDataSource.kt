package com.mzm.moviegoplay.core.data.source.local.room

import com.mzm.moviegoplay.core.data.source.local.entity.PopularMovieEntity
import com.mzm.moviegoplay.core.data.source.local.entity.PopularTVEntity
import com.mzm.moviegoplay.core.data.source.local.entity.TrendingMovieEntity
import com.mzm.moviegoplay.core.data.source.local.entity.TrendingTVEntity
import com.mzm.moviegoplay.core.data.source.local.room.dao.FilmDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Muhammad Zaim Milzam on 08/03/2022.
 * linkedin : Muhammad Zaim Milzam
 */
@Singleton
class LocalDataSource @Inject constructor(
    private val filmDao: FilmDao
) {

    // popular movie
    fun getPopularMovie(): Flow<List<PopularMovieEntity>> = filmDao.getAllPopularMovie()
    suspend fun insertAndDeletePopularMovie(data: List<PopularMovieEntity>) =
        filmDao.addPopularMovie(data)

    suspend fun deletePopularMovie() = filmDao.deleteAllPopularMovie()

    // popular tv
    fun getPopularTv(): Flow<List<PopularTVEntity>> = filmDao.getAllPopularTv()
    suspend fun insertAndDeletePopularTV(film: List<PopularTVEntity>) =
        filmDao.insertAndDeletePopularTV(film)

    suspend fun deletePopularTv() = filmDao.deleteAllPopularTv()

    // trending movie
    fun getTrendingMovie(): Flow<List<TrendingMovieEntity>> = filmDao.getTrendingMovie()
    suspend fun insertAndDeleteTrendingMovie(data: List<TrendingMovieEntity>) =
        filmDao.insertAndDeleteTrendingMovie(data)

    suspend fun deleteAllTrendingMovie() = filmDao.deleteAllTrendingMovie()

    // trending tv
    fun getTrendingTv(): Flow<List<TrendingTVEntity>> = filmDao.getTrendingTv()
    suspend fun insertAndDeleteTrendingTv(data: List<TrendingTVEntity>) =
        filmDao.insertAndDeleteTrendingTV(data)

    suspend fun deleteAllTrendingTv() = filmDao.deleteAllTrendingTv()


}