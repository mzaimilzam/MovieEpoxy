package com.mzm.moviegoplay.core.domain.repository

import com.mzm.moviegoplay.core.data.Resource
import com.mzm.moviegoplay.core.domain.model.Film
import com.mzm.moviegoplay.core.domain.model.PopularMovie
import kotlinx.coroutines.flow.Flow

/**
 * Created by Muhammad Zaim Milzam on 09/06/2022.
 * linkedin : Muhammad Zaim Milzam
 */
interface DataSource {

    fun getTrendingAll(): Flow<Resource<List<Film>>>

    fun getPopularMovie(): Flow<Resource<List<PopularMovie>>>

    fun getPopularTv(): Flow<Resource<List<PopularMovie>>>

    fun getTrendingMovie(): Flow<Resource<List<PopularMovie>>>

    fun getTrendingTv(): Flow<Resource<List<PopularMovie>>>
}