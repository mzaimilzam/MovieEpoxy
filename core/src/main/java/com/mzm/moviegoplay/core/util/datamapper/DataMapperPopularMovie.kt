package com.mzm.moviegoplay.core.util.datamapper

import com.mzm.moviegoplay.core.data.source.local.entity.PopularMovieEntity
import com.mzm.moviegoplay.core.data.source.remote.response.popular_movie.PopularMovieResponse
import com.mzm.moviegoplay.core.domain.model.PopularMovie
import com.mzm.moviegoplay.core.util.stringEmpty

/**
 * Created by Muhammad Zaim Milzam on 09/06/2022.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperPopularMovie {

    fun mapResponseToEntity(input: List<PopularMovieResponse>): List<PopularMovieEntity> {
        val popularMovieEntity = ArrayList<PopularMovieEntity>()
        input.map {
            val data = PopularMovieEntity(
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
            popularMovieEntity.add(data)
        }
        return popularMovieEntity
    }

    fun mapEntitytoModel(input : List<PopularMovieEntity>) : List<PopularMovie> =
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