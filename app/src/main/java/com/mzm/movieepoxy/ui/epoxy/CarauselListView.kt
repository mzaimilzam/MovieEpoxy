package com.mzm.movieepoxy.ui.epoxy

import android.annotation.SuppressLint
import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.mzm.movieepoxy.R
import com.mzm.movieepoxy.utils.KotlinEpoxyHolder
import com.mzm.movieepoxy.utils.loadImage
import com.mzm.moviegoplay.core.domain.model.PopularMovie
import timber.log.Timber


@SuppressLint("NonConstantResourceId")
@EpoxyModelClass(layout = R.layout.ep_carausel_list_view)
abstract class CarauselListView(
    private val context: Context
) : EpoxyModelWithHolder<CarauselListView.Holder>() {

    @EpoxyAttribute
    lateinit var model: PopularMovie

    override fun bind(holder: Holder) {
        super.bind(holder)
        Timber.tag(CarauselListView::class.java.simpleName).d("bind_model : $model")
        holder.imgCarousel.loadImage(context, model.posterPath)
        holder.tvTitleCarousel.text = model.title
        holder.tvBodyCarousel.text = model.overview
    }

    inner class Holder : KotlinEpoxyHolder() {
        val imgCarousel by bind<ImageView>(R.id.iv_poster_caraousel_list)
        val tvTitleCarousel by bind<TextView>(R.id.tv_title_caraousel_list)
        val tvBodyCarousel by bind<TextView>(R.id.tv_body_caraousel_list)
    }
}