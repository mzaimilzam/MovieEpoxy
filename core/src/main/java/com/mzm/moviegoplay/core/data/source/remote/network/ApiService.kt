package com.mzm.moviegoplay.core.data.source.remote.network

import com.mzm.moviegoplay.core.data.source.remote.response.all.ListFilmResponse
import com.mzm.moviegoplay.core.data.source.remote.response.popular_movie.ListPopularMovieResponse
import com.mzm.moviegoplay.core.data.source.remote.response.popular_tv.ListPopularTVResponse
import com.mzm.moviegoplay.core.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Muhammad Zaim Milzam on 11/03/2022.
 * linkedin : Muhammad Zaim Milzam
 */
interface ApiService {

    @GET("trending/all/week")
    suspend fun getTrendingAll(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("page") page: Int = 1
    ): ListFilmResponse

    @GET("movie/popular?language=en-US")
    suspend fun getPopularMovie(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("page") page: Int = 1
    ): ListPopularMovieResponse

    @GET("tv/popular?language=en-US")
    suspend fun getPopularTV(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("page") page: Int = 1
    ): ListPopularTVResponse

    @GET("trending/movie/week?language=en-US")
    suspend fun getTrendingMovie(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("page") page: Int = 1
    ): ListPopularMovieResponse

    @GET("trending/tv/week?language=en-US")
    suspend fun getTrendingTV(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("page") page: Int = 1
    ): ListPopularTVResponse
}