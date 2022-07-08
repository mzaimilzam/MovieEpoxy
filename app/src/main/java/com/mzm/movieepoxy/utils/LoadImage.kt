package com.mzm.movieepoxy.utils

import android.content.Context
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mzm.movieepoxy.R

/**
 * Created by Muhammad Zaim Milzam on 24/04/2022.
 * linkedin : Muhammad Zaim Milzam
 */

fun ImageView.loadImage(
    context: Context,
    url: String,
) {

    // add loading image
    val circularProgressDrawable = CircularProgressDrawable(context)
    circularProgressDrawable.strokeWidth = 10f
    circularProgressDrawable.centerRadius = 50f
    circularProgressDrawable.setColorSchemeColors(
        ContextCompat.getColor(context, R.color.purple_500)
    )
    circularProgressDrawable.start()

    val myOptions = RequestOptions()
        .centerCrop()
        .override(100, 100)

    Glide.with(this)
        .load(url)
        .placeholder(circularProgressDrawable)
        .apply(myOptions)
        .error(R.drawable.ic_image_search_72)
        .into(this)

}

fun ImageView.localLoadImage(
    @DrawableRes placeholder: Int = R.drawable.ic_image_search_72
) {

    val myOptions = RequestOptions()
        .centerCrop()
        .override(1024, 1920)

    Glide.with(this)
        .load(placeholder)
        .apply(myOptions)
        .placeholder(placeholder)
        .error(R.drawable.ic_image_search_72)
        .into(this)
}
