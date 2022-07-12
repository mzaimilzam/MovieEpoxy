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
import com.mzm.moviegoplay.core.domain.model.PopularMovie

@EpoxyModelClass(layout = R.layout.ep_list_film)
abstract class ItemListView(
    private val context: Context,
) : EpoxyModelWithHolder<ItemListView.Holder>() {

    @EpoxyAttribute
    lateinit var model: PopularMovie

    override fun bind(holder: Holder) {
        super.bind(holder)
        holder.image.loadImage(context, model.posterPathUrl)
        holder.title.text = model.title
        holder.genre.text = model.overview
        holder.date.text = model.releaseDate
    }

    inner class Holder : KotlinEpoxyHolder() {
        val image by bind<ImageView>(R.id.iv_item_list)
        val title by bind<TextView>(R.id.tv_title_item_list)
        val genre by bind<TextView>(R.id.tv_genre_item_list)
        val date by bind<TextView>(R.id.tv_date_item_list)
    }
}