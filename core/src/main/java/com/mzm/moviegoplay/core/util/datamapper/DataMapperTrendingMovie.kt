package com.mzm.moviegoplay.core.util.datamapper

import com.mzm.moviegoplay.core.data.source.local.entity.TrendingMovieEntity
import com.mzm.moviegoplay.core.data.source.remote.response.popular_movie.PopularMovieResponse
import com.mzm.moviegoplay.core.domain.model.PopularMovie
import com.mzm.moviegoplay.core.util.stringEmpty
import com.mzm.moviegoplay.core.util.tmdbImageUrl

/**
 * Created by Muhammad Zaim Milzam on 09/06/2022.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperTrendingMovie {

    fun mapResponseToEntity(input: List<PopularMovieResponse>): List<TrendingMovieEntity> {
        val trendingMovieEntity = ArrayList<TrendingMovieEntity>()
        input.map {
            val data = TrendingMovieEntity(
                overview = stringEmpty(it.overview),
                originalLanguage = stringEmpty(it.originalLanguage),
                originalTitle = stringEmpty(it.originalTitle),
                title = stringEmpty(it.title),
                video = it.video ?: false,
                posterPath = stringEmpty(it.posterPath),
                backdropPath = stringEmpty(it.backdropPath),
                releaseDate = stringEmpty(it.releaseDate),
                popularity = it.popularity ?: 0.0,
                voteAverage = it.voteAverage ?: 0.0,
                id = it.id ?: 0,
                adult = it.adult ?: false,
                voteCount = it.voteCount ?: 0
            )
            trendingMovieEntity.add(data)
        }
        return trendingMovieEntity
    }

    fun mapEntitytoModel(input: List<TrendingMovieEntity>): List<PopularMovie> =
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