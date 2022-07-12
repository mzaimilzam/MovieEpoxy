package com.mzm.movieepoxy.ui.epoxy

import androidx.appcompat.widget.AppCompatTextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.mzm.movieepoxy.R
import com.mzm.movieepoxy.utils.KotlinEpoxyHolder

@EpoxyModelClass(layout = R.layout.ep_header_item_list_view)
abstract class HeaderItemListtView : EpoxyModelWithHolder<HeaderItemListtView.Holder>() {

    @EpoxyAttribute
    lateinit var title: String

    override fun bind(holder: Holder) {
        super.bind(holder)
        holder.tvTittle.text = title
    }

    inner class Holder : KotlinEpoxyHolder() {
        val tvTittle by bind<AppCompatTextView>(R.id.header_item_list_title)

    }

}