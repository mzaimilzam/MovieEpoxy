package com.mzm.movieepoxy.feature.movie

import android.content.Context
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.CarouselModel_
import com.airbnb.epoxy.EpoxyController
import com.mzm.movieepoxy.ui.epoxy.CarauselListView_
import com.mzm.movieepoxy.ui.epoxy.HeaderItemListtView_
import com.mzm.movieepoxy.ui.epoxy.HeaderListView_
import com.mzm.movieepoxy.ui.epoxy.ItemListView_
import com.mzm.moviegoplay.core.domain.model.PopularMovie

class MovieController(private val context: Context) : EpoxyController() {

    private val trendingMovie: MutableList<PopularMovie> = mutableListOf()
    private val popularMovie: MutableList<PopularMovie> = mutableListOf()

    fun setTrendingMovie(trendingMovie: MutableList<PopularMovie>) {
        this.trendingMovie.clear()
        this.trendingMovie.addAll(trendingMovie)
        requestModelBuild()
    }


    fun setPopularMovie(popularMovie: MutableList<PopularMovie>) {
        this.popularMovie.clear()
        this.popularMovie.addAll(popularMovie)
        requestModelBuild()
    }

    override fun buildModels() {

        HeaderListView_()
            .id("Header_popular_CaraouselMovie")
            .title("Popular")
            .addIf(this.trendingMovie.isNotEmpty(), this)

        CarouselModel_()
            .padding(Carousel.Padding.dp(16, 2, 16, 2, 8))
            .id("carousel_popular_movie")
            .models(
                this.trendingMovie.map {
                    CarauselListView_(context)
                        .id(it.id)
                        .model(it)
                }
            ).addIf(this.trendingMovie.isNotEmpty(), this)

        HeaderItemListtView_()
            .id("Header_trending_CaraouselMovie")
            .title("Trending")
            .addIf(this.trendingMovie.isNotEmpty(), this)

        this.trendingMovie.forEach {
            ItemListView_(context)
                .id(it.id)
                .model(it)
                .addIf(this.trendingMovie.isNotEmpty(), this)
        }

//        CarouselModel_()
//            .padding(Carousel.Padding.dp(16, 2, 16, 2, 8))
//            .id("carousel_popular_movie")
//            .models(
//                this.trendingMovie.map {
//                    CarauselListView_(context)
//                        .id(it.id)
//                        .model(it)
//                }
//            ).addIf(this.trendingMovie.isNotEmpty(), this)
    }
}