package com.mzm.moviegoplay.core.domain.usecase

import com.mzm.moviegoplay.core.data.Resource
import com.mzm.moviegoplay.core.domain.model.PopularMovie
import kotlinx.coroutines.flow.Flow

/**
 * Created by Muhammad Zaim Milzam on 23/06/2022.
 * linkedin : Muhammad Zaim Milzam
 */
interface MovieUsecase {

    fun getPopularMovie(): Flow<Resource<List<PopularMovie>>>

    fun getPopularTv(): Flow<Resource<List<PopularMovie>>>

    fun getTrendingMovie(): Flow<Resource<List<PopularMovie>>>

    fun getTrendingTv(): Flow<Resource<List<PopularMovie>>>
}