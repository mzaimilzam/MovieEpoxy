package com.mzm.moviegoplay.core.domain.usecase

import com.mzm.moviegoplay.core.data.Resource
import com.mzm.moviegoplay.core.data.source.Respository
import com.mzm.moviegoplay.core.domain.model.PopularMovie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Muhammad Zaim Milzam on 23/06/2022.
 * linkedin : Muhammad Zaim Milzam
 */
class MovieInteractor @Inject constructor(private val repository: Respository) :
    MovieUsecase {
    override fun getPopularMovie(): Flow<Resource<List<PopularMovie>>> =
        repository.getPopularMovie()

    override fun getPopularTv(): Flow<Resource<List<PopularMovie>>> = repository.getPopularTv()

    override fun getTrendingMovie(): Flow<Resource<List<PopularMovie>>> =
        repository.getTrendingMovie()

    override fun getTrendingTv(): Flow<Resource<List<PopularMovie>>> = repository.getTrendingTv()
}