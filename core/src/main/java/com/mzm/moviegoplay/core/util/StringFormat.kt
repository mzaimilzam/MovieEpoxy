package com.mzm.moviegoplay.core.util

/**
 * Created by Muhammad Zaim Milzam on 09/06/2022.
 * linkedin : Muhammad Zaim Milzam
 */

fun stringEmpty(
    text: String?
): String {
    if (text == "" || text == null || text == "null" || text.isNullOrEmpty()) {
        return ""
    }
    return text
}