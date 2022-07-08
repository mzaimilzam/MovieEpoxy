package com.mzm.moviegoplay.core.util

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject


/**
 * Created by Muhammad Zaim Milzam on 17/04/22.
 * linkedin : Muhammad Zaim Milzam
 */

class NetworkConnectionInterceptor @Inject constructor() :
    Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer ${Constants.API_KEY}")
            .build()

        return chain.proceed(request)
    }
}