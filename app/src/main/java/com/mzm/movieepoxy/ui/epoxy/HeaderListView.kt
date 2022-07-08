package com.mzm.movieepoxy.ui.epoxy

import android.annotation.SuppressLint
import androidx.appcompat.widget.AppCompatTextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.mzm.movieepoxy.R
import com.mzm.movieepoxy.utils.KotlinEpoxyHolder

@SuppressLint("NonConstantResourceId")
@EpoxyModelClass(layout = R.layout.ep_header_list_view)
abstract class HeaderListView : EpoxyModelWithHolder<HeaderListView.Holder>() {

    @EpoxyAttribute
    lateinit var title: String

    override fun bind(holder: Holder) {
        super.bind(holder)
        holder.tvTittle.text = title
    }

    inner class Holder : KotlinEpoxyHolder() {
        val tvTittle by bind<AppCompatTextView>(R.id.header_list_title)

    }

}