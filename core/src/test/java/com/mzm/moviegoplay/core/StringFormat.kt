package com.mzm.moviegoplay.core

import org.junit.Assert
import org.junit.Test

/**
 * Created by Muhammad Zaim Milzam on 09/06/2022.
 * linkedin : Muhammad Zaim Milzam
 */

class StringFormat {
    fun stringEmpty(
        text: String?
    ): String {
        if (text == "" || text == null || text == "null" || text.isNullOrEmpty()) {
            return ""
        }
        return text
    }

    @Test
    fun `text should return null or empty`() {
        print(stringEmpty(null))
        print(stringEmpty(""))
        print(stringEmpty("null"))

        Assert.assertEquals(stringEmpty(null), "")
        Assert.assertEquals(stringEmpty(""), "")
        Assert.assertEquals(stringEmpty("null"), "")

    }

    @Test
    fun `text should return value of text`() {
        print(stringEmpty("a"))
        print(stringEmpty("zaim"))
        print(stringEmpty("milzam"))

        Assert.assertEquals(stringEmpty("a"), "a")
        Assert.assertEquals(stringEmpty("zaim"), "zaim")
        Assert.assertEquals(stringEmpty("milzam"), "milzam")
    }
}
