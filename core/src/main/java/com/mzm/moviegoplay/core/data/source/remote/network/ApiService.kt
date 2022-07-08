package com.mzm.moviegoplay.core.data.source.remote.network

import com.mzm.moviegoplay.core.data.source.remote.response.popular_movie.ListPopularMovieResponse
import com.mzm.moviegoplay.core.data.source.remote.response.popular_tv.ListPopularTVResponse
import com.mzm.moviegoplay.core.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Muhammad Zaim Milzam on 11/03/2022.
 * linkedin : Muhammad Zaim Milzam
 */
interface ApiService {

    @GET("movie/popular?language=en-US")
//    @GET("https://api.themoviedb.org/3/movie/popular?api_key=090ef4eef9fcf1858109a3af3c5f34c1&language=en-US&page=1")
    suspend fun getPopularMovie(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("page") page: Int = 1
    ): ListPopularMovieResponse

    //    https://api.themoviedb.org/3/tv/popular?api_key=<<api_key>>&language=en-US&page=1
    @GET("tv/popular?language=en-US")
    suspend fun getPopularTV(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("page") page: Int = 1
    ): Response<ListPopularTVResponse>

    @GET("trending/movie/week?language=en-US")
    suspend fun getTrendingMovie(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("page") page: Int = 1
    ): Response<ListPopularMovieResponse>

    @GET("trending/movie/tv?language=en-US")
    suspend fun getTrendingTV(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("page") page: Int = 1
    ): Response<ListPopularTVResponse>

//    https://api.themoviedb.org/3/movie/now_playing?api_key=<<api_key>>&language=en-US&page=1

}