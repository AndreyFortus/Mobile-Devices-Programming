package com.example.lab_10

import okhttp3.Interceptor
import okhttp3.Response
import android.util.Log

class CustomInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        Log.d("Interceptor", "Request: ${request.url()}")
        val response = chain.proceed(request)
        Log.d("Interceptor", "Response: ${response.code()}")
        return response
    }
}
