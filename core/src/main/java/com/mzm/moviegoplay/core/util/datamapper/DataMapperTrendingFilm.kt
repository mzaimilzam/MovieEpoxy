package com.mzm.moviegoplay.core.util.datamapper

import com.mzm.moviegoplay.core.data.source.local.entity.FilmEntity
import com.mzm.moviegoplay.core.data.source.remote.response.all.FilmResponse
import com.mzm.moviegoplay.core.domain.model.Film
import com.mzm.moviegoplay.core.util.Constants
import com.mzm.moviegoplay.core.util.stringEmpty
import com.mzm.moviegoplay.core.util.tmdbImageUrl

/**
 * Created by Muhammad Zaim Milzam on 09/06/2022.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperTrendingFilm {

    fun mapResponseToEntity(input: List<FilmResponse>): List<FilmEntity> {
        val filmEntity = ArrayList<FilmEntity>()
        input.map {
            val data = FilmEntity(
                overview = stringEmpty(it.overview),
                originalLanguage = stringEmpty(it.originalLanguage),
                originalTitle = stringEmpty(it.originalTitle),
                title = if (it.mediaType == Constants.MEDIA_TYPE_TV) stringEmpty(it.name)
                else stringEmpty(it.title),
                video = it.video ?: false,
                posterPath = stringEmpty(it.posterPath),
                backdropPath = stringEmpty(it.backdropPath),
                mediaType = stringEmpty(it.mediaType),
                releaseDate = stringEmpty(it.releaseDate),
                popularity = it.popularity ?: 0.0,
                voteAverage = it.voteAverage ?: 0.0,
                id = it.id ?: 0,
                adult = it.adult ?: false,
                voteCount = it.voteCount ?: 0
            )
            filmEntity.add(data)
        }
        return filmEntity
    }


    fun mapEntitytoModel(input: List<FilmEntity>): List<Film> =
        input.map {
            Film(
                id = it.id,
                posterPath = it.posterPath,
                title = it.title,
                overview = it.overview,
                releaseDate = it.releaseDate,
                posterPathUrl = tmdbImageUrl(it.posterPath),
                mediaType = it.mediaType
            )
        }
}