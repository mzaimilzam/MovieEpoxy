package com.mzm.moviegoplay.core.data.source.remote

import com.mzm.moviegoplay.core.data.source.remote.network.ApiService
import com.mzm.moviegoplay.core.data.source.remote.response.all.ListFilmResponse
import com.mzm.moviegoplay.core.data.source.remote.response.popular_movie.ListPopularMovieResponse
import com.mzm.moviegoplay.core.data.source.remote.response.popular_tv.ListPopularTVResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Muhammad Zaim Milzam on 08/03/2022.
 * linkedin : Muhammad Zaim Milzam
 */
@Singleton
class RemoteDataSource @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun trendingAll(): Flow<ApiResponse<ListFilmResponse?>> {
        return flow {
            try {
                val data = apiService.getTrendingAll()
                if (data.results.isNullOrEmpty()) {
                    emit(ApiResponse.Empty)
                }
                emit(ApiResponse.Success(data))
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun popularMovie(): Flow<ApiResponse<ListPopularMovieResponse?>> {
        return flow {
            try {
                val data = apiService.getPopularMovie()
                if (data.results.isNullOrEmpty()) {
                    emit(ApiResponse.Empty)
                }
                emit(ApiResponse.Success(data))
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getPopularTv(): Flow<ApiResponse<ListPopularTVResponse?>> {
        return flow {
            try {
                val response = apiService.getPopularTV()
                if (response.results.isNullOrEmpty()) {
                    emit(ApiResponse.Empty)
                } else {
                    emit(ApiResponse.Success(response))
                }
            } catch (e: HttpException) {
                emit(ApiResponse.Error(e.code().toString()))
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)

    }

    suspend fun trendingMovie(): Flow<ApiResponse<ListPopularMovieResponse?>> {
        return flow {
            try {
                val response = apiService.getTrendingMovie()
                if (response.results.isNullOrEmpty()) {
                    emit(ApiResponse.Empty)
                } else {
                    emit(ApiResponse.Success(response))
                }
            } catch (e: HttpException) {
                emit(ApiResponse.Error(e.code().toString()))
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun trendingTv(): Flow<ApiResponse<ListPopularTVResponse?>> {
        return flow {
            try {
                val response = apiService.getTrendingTV()
                if (response.results.isNullOrEmpty()) {
                    emit(ApiResponse.Empty)
                } else {
                    emit(ApiResponse.Success(response))
                }
            } catch (e: HttpException) {
                emit(ApiResponse.Error(e.code().toString()))
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}