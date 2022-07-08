package com.mzm.movieepoxy.feature.home

import android.content.Context
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.CarouselModel_
import com.airbnb.epoxy.EpoxyController
import com.mzm.movieepoxy.ui.epoxy.CarauselListView_
import com.mzm.movieepoxy.ui.epoxy.HeaderListView_
import com.mzm.moviegoplay.core.domain.model.PopularMovie

class HomeController(private val context: Context) : EpoxyController() {

    private val popularMovie: MutableList<PopularMovie> = mutableListOf()
    private val popularSeries: MutableList<PopularMovie> = mutableListOf()
    private val trendingMovie: MutableList<PopularMovie> = mutableListOf()
    private val trendingSeries: MutableList<PopularMovie> = mutableListOf()

    fun setPopularMovie(popularMovie: MutableList<PopularMovie>) {
        this.popularMovie.clear()
        this.popularMovie.addAll(popularMovie)
        requestModelBuild()
    }

    fun setPopularSeries(popularSeries: MutableList<PopularMovie>) {
        this.popularSeries.clear()
        this.popularSeries.addAll(popularSeries)
        requestModelBuild()
    }

    fun setTrendingMovie(trendingMovie: MutableList<PopularMovie>) {
        this.trendingMovie.clear()
        this.trendingMovie.addAll(trendingMovie)
        requestModelBuild()
    }

    fun setTrendingSeries(trendingSeries: MutableList<PopularMovie>) {
        this.trendingSeries.clear()
        this.trendingSeries.addAll(trendingSeries)
        requestModelBuild()
    }


    override fun buildModels() {

        // trending movie
        HeaderListView_()
            .id("header_trending_movie")
            .title("Trending Movie")
            .addIf(this.trendingMovie.isNotEmpty(), this)

        CarouselModel_()
            .padding(Carousel.Padding.dp(16, 2, 16, 2, 8))
            .id("carousel_trending_movie")
            .models(
                this.trendingMovie.map {
                    CarauselListView_(context)
                        .id(it.id)
                        .model(it)
                }
            )
            .addIf(this.trendingMovie.isNotEmpty(), this)

        // trending series
        HeaderListView_()
            .id("header_trending_series")
            .title("Trending Series")
            .addIf(this.trendingSeries.isNotEmpty(), this)

        CarouselModel_()
            .padding(Carousel.Padding.dp(16, 2, 16, 2, 8))
            .id("carousel_trending_series")
            .models(
                this.trendingSeries.map {
                    CarauselListView_(context)
                        .id(it.id)
                        .model(it)
                }
            )
            .addIf(this.trendingSeries.isNotEmpty(), this)

        // popular movie
        HeaderListView_()
            .id("header_popular_movie")
            .title("Popular Movie")
            .addIf(this.popularMovie.isNotEmpty(), this)

        CarouselModel_()
            .padding(Carousel.Padding.dp(16, 2, 16, 2, 8))
            .id("carousel_popular_movie")
            .models(
                this.popularMovie.map {
                    CarauselListView_(context)
                        .id(it.id)
                        .model(it)
                }
            )
            .addIf(this.popularMovie.isNotEmpty(), this)

        // popular series
        HeaderListView_()
            .id("header_popular_series")
            .title("Popular Series")
            .addIf(this.popularSeries.isNotEmpty(), this)

        CarouselModel_()
            .padding(Carousel.Padding.dp(16, 2, 16, 2, 8))
            .id("carousel_popular_series")
            .models(
                this.popularSeries.map {
                    CarauselListView_(context)
                        .id(it.id)
                        .model(it)
                }
            )
            .addIf(this.popularSeries.isNotEmpty(), this)
    }


}