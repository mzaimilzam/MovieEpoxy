package com.mzm.moviegoplay.core.util.datamapper

import com.mzm.moviegoplay.core.data.source.local.entity.TrendingTVEntity
import com.mzm.moviegoplay.core.data.source.remote.response.popular_tv.PopularTvResponse
import com.mzm.moviegoplay.core.domain.model.PopularMovie
import com.mzm.moviegoplay.core.util.stringEmpty
import com.mzm.moviegoplay.core.util.tmdbImageUrl

/**
 * Created by Muhammad Zaim Milzam on 09/06/2022.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperTrendingTV {

    fun mapResponseToEntity(input: List<PopularTvResponse>): List<TrendingTVEntity> {
        val trendingTvEntity = ArrayList<TrendingTVEntity>()
        input.map {
            val data = TrendingTVEntity(
                overview = stringEmpty(it.overview),
                originalLanguage = stringEmpty(it.originalLanguage),
                originalTitle = stringEmpty(it.originalName),
                title = stringEmpty(it.name),
                posterPath = stringEmpty(it.posterPath),
                backdropPath = stringEmpty(it.backdropPath),
                releaseDate = stringEmpty(it.firstAirDate),
                popularity = it.popularity ?: 0.0,
                voteAverage = it.voteAverage ?: 0.0,
                id = it.id ?: 0,
                voteCount = it.voteCount ?: 0
            )
            trendingTvEntity.add(data)
        }
        return trendingTvEntity
    }

    fun mapEntitytoModel(input: List<TrendingTVEntity>): List<PopularMovie> =
        input.map {
            PopularMovie(
                id = it.id,
                posterPath = it.posterPath,
                title = it.title,
                overview = it.overview,
                releaseDate = it.releaseDate,
                posterPathUrl = tmdbImageUrl(it.posterPath)
            )
        }
}