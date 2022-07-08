package com.mzm.moviegoplay.core.data.source

import com.mzm.moviegoplay.core.data.NetworkBoundResource
import com.mzm.moviegoplay.core.data.Resource
import com.mzm.moviegoplay.core.data.source.local.room.LocalDataSource
import com.mzm.moviegoplay.core.data.source.remote.ApiResponse
import com.mzm.moviegoplay.core.data.source.remote.RemoteDataSource
import com.mzm.moviegoplay.core.data.source.remote.response.all.FilmResponse
import com.mzm.moviegoplay.core.data.source.remote.response.all.ListFilmResponse
import com.mzm.moviegoplay.core.data.source.remote.response.popular_movie.ListPopularMovieResponse
import com.mzm.moviegoplay.core.data.source.remote.response.popular_movie.PopularMovieResponse
import com.mzm.moviegoplay.core.data.source.remote.response.popular_tv.ListPopularTVResponse
import com.mzm.moviegoplay.core.data.source.remote.response.popular_tv.PopularTvResponse
import com.mzm.moviegoplay.core.domain.model.Film
import com.mzm.moviegoplay.core.domain.model.PopularMovie
import com.mzm.moviegoplay.core.domain.repository.DataSource
import com.mzm.moviegoplay.core.util.datamapper.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Muhammad Zaim Milzam on 08/03/2022.
 * linkedin : Muhammad Zaim Milzam
 */
@Singleton
class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : DataSource {

    override fun getTrendingAll(): Flow<Resource<List<Film>>> =
        object : NetworkBoundResource<List<Film>, ListFilmResponse>() {
            override fun loadFromDB(): Flow<List<Film>> {
                return localDataSource.getFilm().map {
                    DataMapperTrendingFilm.mapEntitytoModel(it)
                }
            }

            override fun shouldFetch(data: List<Film>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<ListFilmResponse>> =
                remoteDataSource.trendingAll() as Flow<ApiResponse<ListFilmResponse>>

            override suspend fun saveCallResult(data: ListFilmResponse) {
                val submit =
                    DataMapperTrendingFilm.mapResponseToEntity(data.results as List<FilmResponse>)
                localDataSource.insertAndDeleteFilm(submit)
            }

            override suspend fun emptyDataBase() {
                localDataSource.deleteFilm()
            }

        }.asFlow()


    override fun getPopularMovie(): Flow<Resource<List<PopularMovie>>> =
        object : NetworkBoundResource<List<PopularMovie>, ListPopularMovieResponse>() {
            override fun loadFromDB(): Flow<List<PopularMovie>> {
                return localDataSource.getPopularMovie().map {
                    DataMapperPopularMovie.mapEntitytoModel(it)
                }
            }

            override fun shouldFetch(data: List<PopularMovie>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<ListPopularMovieResponse>> =
                remoteDataSource.popularMovie() as Flow<ApiResponse<ListPopularMovieResponse>>

            override suspend fun saveCallResult(data: ListPopularMovieResponse) {
                val submit =
                    DataMapperPopularMovie.mapResponseToEntity(data.results as List<PopularMovieResponse>)
                localDataSource.insertAndDeletePopularMovie(submit)
            }

            override suspend fun emptyDataBase() {
                localDataSource.deletePopularMovie()
            }

        }.asFlow()

    override fun getPopularTv(): Flow<Resource<List<PopularMovie>>> =
        object : NetworkBoundResource<List<PopularMovie>, ListPopularTVResponse>() {
            override fun loadFromDB(): Flow<List<PopularMovie>> {
                return localDataSource.getPopularTv().map {
                    DataMapperPopularTV.mapEntitytoModel(it)
                }
            }

            override fun shouldFetch(data: List<PopularMovie>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<ListPopularTVResponse>> =
                remoteDataSource.getPopularTv() as Flow<ApiResponse<ListPopularTVResponse>>

            override suspend fun saveCallResult(data: ListPopularTVResponse) {
                val submit =
                    DataMapperPopularTV.mapResponseToEntity(data.results as List<PopularTvResponse>)
                localDataSource.insertAndDeletePopularTV(submit)
            }

            override suspend fun emptyDataBase() {
                localDataSource.deletePopularTv()
            }

        }.asFlow()

    override fun getTrendingMovie(): Flow<Resource<List<PopularMovie>>> =
        object : NetworkBoundResource<List<PopularMovie>, ListPopularMovieResponse>() {
            override fun loadFromDB(): Flow<List<PopularMovie>> {
                return localDataSource.getTrendingMovie().map {
                    DataMapperTrendingMovie.mapEntitytoModel(it)
                }
            }

            override fun shouldFetch(data: List<PopularMovie>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<ListPopularMovieResponse>> =
                remoteDataSource.trendingMovie() as Flow<ApiResponse<ListPopularMovieResponse>>

            override suspend fun saveCallResult(data: ListPopularMovieResponse) {
                val submit =
                    DataMapperTrendingMovie.mapResponseToEntity(data.results as List<PopularMovieResponse>)
                localDataSource.insertAndDeleteTrendingMovie(submit)
            }

            override suspend fun emptyDataBase() {
                localDataSource.deleteAllTrendingMovie()
            }

        }.asFlow()


    override fun getTrendingTv(): Flow<Resource<List<PopularMovie>>> =
        object : NetworkBoundResource<List<PopularMovie>, ListPopularTVResponse>() {
            override fun loadFromDB(): Flow<List<PopularMovie>> {
                return localDataSource.getTrendingTv().map {
                    DataMapperTrendingTV.mapEntitytoModel(it)
                }
            }

            override fun shouldFetch(data: List<PopularMovie>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<ListPopularTVResponse>> =
                remoteDataSource.trendingTv() as Flow<ApiResponse<ListPopularTVResponse>>

            override suspend fun saveCallResult(data: ListPopularTVResponse) {
                val submit =
                    DataMapperTrendingTV.mapResponseToEntity(data.results as List<PopularTvResponse>)
                localDataSource.insertAndDeleteTrendingTv(submit)
            }

            override suspend fun emptyDataBase() {
                localDataSource.deleteAllTrendingTv()
            }

        }.asFlow()


}