package com.example.gitmeet.repository

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {

        private lateinit var retrofit: Retrofit

        private fun getRetrofitInstance(): Retrofit {
            if (!::retrofit.isInitialized) {

                retrofit = Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .client(
                        OkHttpClient.Builder()
                            .addInterceptor {
                                val req = it.request()
                                    .newBuilder()
                                    .addHeader("Accept", "application/vnd.github.v3+json")
                                    .addHeader("Authorization", "")
                                    .build()
                                it.proceed(req)
                            }
                            .addInterceptor(
                                HttpLoggingInterceptor().apply {
                                    level = HttpLoggingInterceptor.Level.BODY
                                }
                            )
                            .build()
                    )
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }

        fun <T> createService(servClass: Class<T>): T {
            return getRetrofitInstance().create(servClass)
        }
    }
}