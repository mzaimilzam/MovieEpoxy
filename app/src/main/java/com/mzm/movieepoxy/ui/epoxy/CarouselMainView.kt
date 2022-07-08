package com.mzm.movieepoxy.ui.epoxy

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.mzm.movieepoxy.R
import com.mzm.movieepoxy.utils.KotlinEpoxyHolder
import com.mzm.movieepoxy.utils.loadImage
import com.mzm.moviegoplay.core.domain.model.Film

@EpoxyModelClass(layout = R.layout.ep_carousel_home)
abstract class CarouselMainView(
    private val context: Context,
) : EpoxyModelWithHolder<CarouselMainView.Holder>() {

    @EpoxyAttribute
    lateinit var model: Film

    override fun bind(holder: Holder) {
        super.bind(holder)
        holder.image.loadImage(context, model.posterPathUrl)
        holder.title.text = model.title
        holder.genre.text = model.overview
        holder
    }

    inner class Holder : KotlinEpoxyHolder() {
        val number by bind<TextView>(R.id.tv_number_film)
        val image by bind<ImageView>(R.id.iv_carousel_home)
        val title by bind<TextView>(R.id.tv_title_carousel_home)
        val genre by bind<TextView>(R.id.tv_genre_carousel_home)
    }
}