package com.cesarsicas.data.retrofit

import com.cesarsicas.data.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var req = chain.request()

        req.newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("x-api-key", BuildConfig.TOKEN)
            .build()

        return chain.proceed(req)

    }
}