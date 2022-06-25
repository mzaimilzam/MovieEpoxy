package com.mzm.moviegoplay.core.util.datamapper

import com.mzm.moviegoplay.core.data.source.local.entity.PopularTVEntity
import com.mzm.moviegoplay.core.data.source.remote.response.popular_tv.PopularTvResponse
import com.mzm.moviegoplay.core.domain.model.PopularMovie
import com.mzm.moviegoplay.core.util.stringEmpty

/**
 * Created by Muhammad Zaim Milzam on 09/06/2022.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperPopularTV {

    fun mapResponseToEntity(input: List<PopularTvResponse>): List<PopularTVEntity> {
        val popularTVEntity = ArrayList<PopularTVEntity>()
        input.map {
            val data = PopularTVEntity(
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
            popularTVEntity.add(data)
        }
        return popularTVEntity
    }

    fun mapEntitytoModel(input : List<PopularTVEntity>) : List<PopularMovie> =
        input.map {
            PopularMovie(
                id = it.id,
                posterPath = it.posterPath,
                title = it.title,
                overview = it.overview,
                releaseDate = it.releaseDate
            )
        }
}